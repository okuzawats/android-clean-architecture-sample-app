package com.okuzawats.cleanarchitecture.datasource.common

import com.okuzawats.cleanarchitecture.datasource.dog.DogImage
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("dog.json")
    suspend fun getRandomImage(): Response<DogImage>
}
