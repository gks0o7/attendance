package com.example.attend.domain.repository

import com.example.attend.common.Resource
import com.example.attend.domain.model.User

interface DataLocalSource {

    suspend fun loginUser(username: String, password: String): Resource<User>
}