package com.okuzawats.cleanarchitecture.datasource.dog

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogImage(
    @SerialName("message") val imageUrl: String,
    @SerialName("status") val status: String,
)
