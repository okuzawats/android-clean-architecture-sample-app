package com.okuzawats.cleanarchitecture.feature.dog.viewmodel

sealed class MainViewModelEvent {
    object NavigateToLicense : MainViewModelEvent()
}
