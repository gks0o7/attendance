package com.example.attend.data

import com.example.attend.data.dao.UserDaoImpl
import com.example.attend.domain.source.UserDao
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class DbFactory @Inject constructor(
    private val dbModule: DbModule
) {
    lateinit var userDao: UserDao

    fun init() {
        userDao = UserDaoImpl(dbModule)
    }
}