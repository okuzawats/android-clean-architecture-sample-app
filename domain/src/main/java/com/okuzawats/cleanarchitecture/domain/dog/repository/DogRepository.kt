package com.okuzawats.cleanarchitecture.domain.dog.repository

import com.okuzawats.cleanarchitecture.domain.dog.model.Dog

interface DogRepository {
    suspend fun getRandom(): Dog
}
