package com.example.attend.domain.source

import com.example.attend.common.Resource
import com.example.attend.domain.model.User


interface UserDao {

    suspend fun login(username:String, password: String): Resource<User>
}