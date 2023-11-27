package com.example.attend.data.repository

import com.example.attend.common.Resource
import com.example.attend.domain.model.User
import com.example.attend.domain.repository.AuthRepository
import com.example.attend.domain.repository.DataLocalSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataLocalSource: DataLocalSource
) : AuthRepository {

    override suspend fun login(username: String, password: String): Resource<User> {
        return dataLocalSource.loginUser(username, password)
    }
}