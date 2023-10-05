package com.fahad.project.x_i.modules

import android.app.Application
import com.fahad.project.common_domain.providers.CurrentActivityProvider
import com.fahad.project.x_i.SuperApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CurrentActivityProviderModule {

    @Provides
    @Singleton
    fun exposeCurrentActivityProvider(application: Application): CurrentActivityProvider = application as SuperApplication
}
