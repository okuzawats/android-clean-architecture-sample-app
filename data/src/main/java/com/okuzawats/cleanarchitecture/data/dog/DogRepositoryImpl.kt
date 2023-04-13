package com.okuzawats.cleanarchitecture.data.dog

import com.okuzawats.cleanarchitecture.domain.dog.model.Dog
import com.okuzawats.cleanarchitecture.domain.dog.repository.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val dogDataSource: DogDataSource,
    private val dataToDomainMapper: DataToDomainMapper,
) : DogRepository {
    override suspend fun getRandom(): Dog {
        return try {
            val dogImage = dogDataSource.getRandomDogImage()
            dataToDomainMapper.toDomain(dogImage)
        } catch (e: Throwable) {
            dataToDomainMapper.toDomain(e)
        }
    }
}
