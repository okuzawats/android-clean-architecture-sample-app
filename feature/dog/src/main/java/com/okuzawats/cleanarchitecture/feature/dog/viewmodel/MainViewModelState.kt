package com.okuzawats.cleanarchitecture.feature.dog.viewmodel

import com.okuzawats.cleanarchitecture.feature.dog.model.DogImageGetResult

sealed class MainViewModelState {
    companion object {
        fun initial(): MainViewModelState {
            return Initial
        }

        fun from(result: DogImageGetResult): MainViewModelState {
            return when (result) {
                is DogImageGetResult.FetchFailed -> {
                    LoadFailed
                }
                is DogImageGetResult.Fetched -> {
                    Loaded(image = result.dogImage)
                }
            }
        }
    }

    object Initial : MainViewModelState()
    object Loading : MainViewModelState()
    data class Loaded(val image: String) : MainViewModelState()
    object LoadFailed : MainViewModelState()
}
