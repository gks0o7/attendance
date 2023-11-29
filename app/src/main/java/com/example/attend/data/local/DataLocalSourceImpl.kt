package com.example.attend.data.local

import com.example.attend.common.Resource
import com.example.attend.data.mapper.toUser
import com.example.attend.domain.model.User
import com.example.attend.domain.repository.DataLocalSource
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataLocalSourceImpl @Inject constructor(
    private val attendanceDB: AttendanceDB,
    private val coroutineContext: CoroutineContext
) : DataLocalSource {


    override suspend fun loginUser(username: String, password: String): Resource<User> {
        return try {
            val existingUser = attendanceDB.userDao().getUser(username)
            if (existingUser != null) {
                if (existingUser.password == password) {
                    Resource.Success(existingUser.toUser())
                } else {
                    Resource.Error("Invalid credentials")
                }
            } else {
                Resource.Error("Username not found")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage)
        }
    }
}