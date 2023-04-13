package com.okuzawats.cleanarchitecture.data.dog

interface DogDataSource {
    suspend fun getRandomDogImage(): String
}
