package com.example.attend.di

import com.example.attend.data.local.DataLocalSourceImpl
import com.example.attend.data.repository.AuthRepositoryImpl
import com.example.attend.domain.repository.AuthRepository
import com.example.attend.domain.repository.DataLocalSource
import dagger.Binds
import javax.inject.Singleton

abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun provideAuthRepository(authRepository: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun provideDataLocalSource(dataLocalSource: DataLocalSourceImpl): DataLocalSource
}