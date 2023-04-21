package com.okuzawats.cleanarchitecture.datasource

import com.okuzawats.cleanarchitecture.data.dog.DogDataSource
import com.okuzawats.cleanarchitecture.datasource.common.ApiClient
import com.okuzawats.cleanarchitecture.datasource.common.ApiClientProvider
import com.okuzawats.cleanarchitecture.datasource.dog.DogDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    fun provideDogDataSource(impl: DogDataSourceImpl): DogDataSource {
        return impl
    }

    @ExperimentalSerializationApi
    @Provides
    fun provideApiClient(apiClientProvider: ApiClientProvider): ApiClient {
        return apiClientProvider.provide()
    }
}
