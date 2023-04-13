package com.okuzawats.cleanarchitecture.datasource.dog

import com.okuzawats.cleanarchitecture.data.dog.DogDataSource
import com.okuzawats.cleanarchitecture.datasource.common.ApiClient
import java.io.IOException
import javax.inject.Inject

class DogDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient,
) : DogDataSource {
    override suspend fun getRandomDogImage(): String {
        return try {
            val response = apiClient.getRandomImage()
            if (response.isSuccessful) {
                checkNotNull(response.body()).imageUrl
            } else {
                throw Throwable("response was not success")
            }
        } catch (e: IOException) {
            throw Throwable("response not received")
        }
    }
}
