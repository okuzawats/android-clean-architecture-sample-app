package com.okuzawats.cleanarchitecture.data

import com.okuzawats.cleanarchitecture.data.dog.DogRepositoryImpl
import com.okuzawats.cleanarchitecture.domain.dog.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun provideDogImageRepository(impl: DogRepositoryImpl): DogRepository {
        return impl
    }
}
