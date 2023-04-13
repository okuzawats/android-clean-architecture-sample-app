package com.okuzawats.cleanarchitecture.domain.dog

import com.okuzawats.cleanarchitecture.domain.dog.model.Dog
import kotlinx.coroutines.flow.Flow

interface GetRandomDogUseCase {
    suspend operator fun invoke(): Flow<Dog>
}
