package com.okuzawats.cleanarchitecture.di

import com.okuzawats.cleanarchitecture.domain.dog.GetRandomDogUseCase
import com.okuzawats.cleanarchitecture.domain.dog.impl.GetRandomDogUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideGetRandomDogUseCase(impl: GetRandomDogUseCaseImpl): GetRandomDogUseCase {
        return impl
    }
}
