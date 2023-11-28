package com.example.attend.di

import android.content.Context
import com.example.attend.AppController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppController(@ApplicationContext context: Context): AppController {
        return context as AppController
    }
}