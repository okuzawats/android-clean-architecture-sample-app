package com.okuzawats.cleanarchitecture.feature.dog.view

sealed class UiState {
    companion object {
        fun initial(): UiState = Initial
    }

    object Initial : UiState()
    object Loading : UiState()
    data class Image(val url: String) : UiState()
    object Error : UiState()
}
