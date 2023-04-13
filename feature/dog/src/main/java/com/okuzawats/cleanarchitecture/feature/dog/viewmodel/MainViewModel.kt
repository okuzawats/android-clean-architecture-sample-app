package com.okuzawats.cleanarchitecture.feature.dog.viewmodel

import androidx.lifecycle.viewModelScope
import com.okuzawats.cleanarchitecture.domain.dog.GetRandomDogUseCase
import com.okuzawats.cleanarchitecture.feature.architecture.ViewModel
import com.okuzawats.cleanarchitecture.feature.dog.mapper.DomainToPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomDogUseCase: GetRandomDogUseCase,
    private val domainToPresentationMapper: DomainToPresentationMapper,
) : ViewModel<MainViewModelState, MainViewModelEvent>() {
    fun onEntered() {
        viewModelScope.launch {
            onNewState(MainViewModelState.Loading)
            getRandomDogUseCase()
                .map {
                    domainToPresentationMapper.toPresentation(it)
                }
                .map {
                    MainViewModelState.from(it)
                }
                .onEach {
                    onNewState(it)
                }
                .launchIn(this)
        }
    }

    fun onLicenseAction() {
        viewModelScope.launch {
            onNewEvent(MainViewModelEvent.NavigateToLicense)
        }
    }

    override fun initialState(): MainViewModelState {
        return MainViewModelState.initial()
    }
}
