package com.okuzawats.cleanarchitecture.feature.dog.model

sealed class DogImageGetResult {
    data class Fetched(val dogImage: String) : DogImageGetResult()
    object FetchFailed : DogImageGetResult()
}
