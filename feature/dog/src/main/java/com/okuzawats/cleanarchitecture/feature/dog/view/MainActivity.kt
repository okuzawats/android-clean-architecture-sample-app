package com.okuzawats.cleanarchitecture.feature.dog.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.okuzawats.cleanarchitecture.feature.dog.composable.ErrorView
import com.okuzawats.cleanarchitecture.feature.dog.composable.ImageView
import com.okuzawats.cleanarchitecture.feature.dog.composable.InitialView
import com.okuzawats.cleanarchitecture.feature.dog.composable.LoadingView
import com.okuzawats.cleanarchitecture.feature.dog.mapper.PresentationToUiMapper
import com.okuzawats.cleanarchitecture.feature.dog.navigation.MainNavigator
import com.okuzawats.cleanarchitecture.feature.dog.viewmodel.MainViewModel
import com.okuzawats.cleanarchitecture.feature.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var presentationToUiMapper: PresentationToUiMapper

    @Inject
    lateinit var mainNavigator: MainNavigator

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.event.onEach { event ->
            when (presentationToUiMapper.toUi(event)) {
                is UiEvent.NavigateToLicense -> {
                    mainNavigator.toLicense()
                }
            }
        }.launchIn(lifecycleScope)

        val viewState = viewModel.state.map {
            presentationToUiMapper.toUi(it)
        }

        setContent {
            CleanArchitectureTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val state = viewState.collectAsState(initial = UiState.initial())
                    when (state.value) {
                        is UiState.Initial -> {
                            InitialView()
                        }
                        is UiState.Loading -> {
                            LoadingView()
                        }
                        is UiState.Image -> {
                            Column {
                                Button(onClick = viewModel::onLicenseAction) {
                                    Text(text = "LICENSE")
                                }
                                ImageView(
                                    imageUrl = (state.value as UiState.Image).url,
                                )
                            }
                        }
                        is UiState.Error -> {
                            ErrorView()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onEntered()
    }
}
