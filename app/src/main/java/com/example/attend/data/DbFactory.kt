package com.example.attend.data

import com.example.attend.data.dao.UserDaoImpl
import com.example.attend.domain.source.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbFactory @Inject constructor(

) {
    lateinit var userDao: UserDao

    fun init(dbModule: DbModule) {
        userDao = UserDaoImpl(dbModule)
    }
}