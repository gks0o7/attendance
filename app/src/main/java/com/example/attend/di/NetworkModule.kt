package com.example.attend.di

import com.example.attend.data.local.DataLocalSourceImpl
import com.example.attend.data.repository.AuthRepositoryImpl
import com.example.attend.domain.repository.AuthRepository
import com.example.attend.domain.repository.DataLocalSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun provideAuthRepository(authRepository: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun provideDataLocalSource(dataLocalSource: DataLocalSourceImpl): DataLocalSource
}