package com.example.attend.di

import android.content.Context
import androidx.room.Room
import com.example.attend.data.local.AttendanceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class DataModule {



    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.IO

    @Provides
    @Singleton
    fun provideAttendanceDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AttendanceDB::class.java, "attendance.db")
            .createFromAsset("database/attend.db")
            .build()
}
