package com.example.attend.data.local

import com.example.attend.common.Resource
import com.example.attend.domain.model.User
import com.example.attend.domain.repository.DataLocalSource
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataLocalSourceImpl @Inject constructor(
    private val attendanceDB: AttendanceDB,
    private val coroutineContext: CoroutineContext
) : DataLocalSource {


    override suspend fun loginUser(username: String, password: String): Resource<User> {
        TODO("Not yet implemented")
    }
}