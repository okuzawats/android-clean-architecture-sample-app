package com.okuzawats.cleanarchitecture.domain.getrandomdogimage.impl

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.okuzawats.cleanarchitecture.domain.dog.GetRandomDogUseCase
import com.okuzawats.cleanarchitecture.domain.dog.impl.GetRandomDogUseCaseImpl
import com.okuzawats.cleanarchitecture.domain.dog.model.Dog
import com.okuzawats.cleanarchitecture.domain.dog.repository.DogRepository
import com.okuzawats.cleanarchitecture.test.CoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetRandomDogUseCaseImplTest {

    @get:Rule
    val coroutineRule = CoroutineRule()

    private lateinit var dogRepository: DogRepository

    private lateinit var target: GetRandomDogUseCase

    @Before
    fun setUp() {
        dogRepository = mockk()

        target = GetRandomDogUseCaseImpl(
            dogRepository = dogRepository,
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun execution_emits_what_repository_returns() = runTest {
        coEvery { dogRepository.getRandom() } returns Dog.Success("I am an image of a dog!")

        target().test {
            val emitted = awaitItem()
            assertThat((emitted as Dog.Success).image).isEqualTo("I am an image of a dog!")
            awaitComplete()
        }
    }
}
