package com.okuzawats.cleanarchitecture

import com.okuzawats.cleanarchitecture.feature.dog.navigation.MainNavigator
import com.okuzawats.cleanarchitecture.navigator.MainNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NavigatorModule {
    @Provides
    fun provideMainNavigator(impl: MainNavigatorImpl): MainNavigator {
        return impl
    }
}
