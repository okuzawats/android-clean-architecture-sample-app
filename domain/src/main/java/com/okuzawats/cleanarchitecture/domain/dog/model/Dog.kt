package com.okuzawats.cleanarchitecture.domain.dog.model

sealed class Dog {
    data class Success(val image: String) : Dog()
    object Failure : Dog()
}
