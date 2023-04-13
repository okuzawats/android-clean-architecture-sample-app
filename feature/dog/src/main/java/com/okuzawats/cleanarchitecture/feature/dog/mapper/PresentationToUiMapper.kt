package com.okuzawats.cleanarchitecture.feature.dog.mapper

import com.okuzawats.cleanarchitecture.feature.dog.viewmodel.MainViewModelEvent
import com.okuzawats.cleanarchitecture.feature.dog.viewmodel.MainViewModelState
import com.okuzawats.cleanarchitecture.feature.dog.view.UiEvent
import com.okuzawats.cleanarchitecture.feature.dog.view.UiState
import javax.inject.Inject

class PresentationToUiMapper @Inject constructor() {
    fun toUi(presentationState: MainViewModelState): UiState {
        return when (presentationState) {
            is MainViewModelState.Initial -> {
                UiState.Initial
            }
            is MainViewModelState.Loading -> {
                UiState.Loading
            }
            is MainViewModelState.Loaded -> {
                UiState.Image(
                    url = presentationState.image,
                )
            }
            is MainViewModelState.LoadFailed -> {
                UiState.Error
            }
        }
    }

    fun toUi(presentationEvent: MainViewModelEvent): UiEvent {
        return when (presentationEvent) {
            is MainViewModelEvent.NavigateToLicense -> {
                UiEvent.NavigateToLicense
            }
        }
    }
}
