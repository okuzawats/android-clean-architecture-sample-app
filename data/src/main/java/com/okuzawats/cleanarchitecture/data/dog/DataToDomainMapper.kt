package com.okuzawats.cleanarchitecture.data.dog

import com.okuzawats.cleanarchitecture.domain.dog.model.Dog
import javax.inject.Inject

class DataToDomainMapper @Inject constructor() {
    fun toDomain(string: String): Dog {
        return Dog.Success(string)
    }

    fun toDomain(throwable: Throwable): Dog {
        return Dog.Failure
    }
}
