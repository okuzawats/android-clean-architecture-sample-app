package com.okuzawats.cleanarchitecture.domain.dog.impl

import com.okuzawats.cleanarchitecture.domain.dog.repository.DogRepository
import com.okuzawats.cleanarchitecture.domain.dog.model.Dog
import com.okuzawats.cleanarchitecture.domain.dog.GetRandomDogUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetRandomDogUseCaseImpl @Inject constructor(
    private val dogRepository: DogRepository,
) : GetRandomDogUseCase {
    override suspend fun invoke(): Flow<Dog> {
        return flowOf(dogRepository.getRandom())
    }
}
