package com.okuzawats.cleanarchitecture.feature.dog.mapper

import com.okuzawats.cleanarchitecture.domain.dog.model.Dog
import com.okuzawats.cleanarchitecture.feature.dog.model.DogImageGetResult
import javax.inject.Inject

class DomainToPresentationMapper @Inject constructor() {
    fun toPresentation(dog: Dog): DogImageGetResult {
        return when (dog) {
            is Dog.Success -> {
                DogImageGetResult.Fetched(dogImage = dog.image)
            }
            is Dog.Failure -> {
                DogImageGetResult.FetchFailed
            }
        }
    }
}
