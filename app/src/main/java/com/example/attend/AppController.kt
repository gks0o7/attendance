package com.example.attend

import android.app.Application
import com.example.attend.data.DbFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AppController: Application() {

    @Inject
    lateinit var dbFactory: DbFactory

    override fun onCreate() {
        super.onCreate()
    }
}