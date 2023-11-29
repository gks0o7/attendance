package com.example.attend.data.repository

import com.example.attend.common.Resource
import com.example.attend.data.local.request.AddTeacherRequest
import com.example.attend.domain.model.User
import com.example.attend.domain.repository.AdminRepository
import com.example.attend.domain.repository.DataLocalSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val dataLocalSource: DataLocalSource
) : AdminRepository {

    override suspend fun getTeachers(): Flow<List<User>> {
        return dataLocalSource.getTeachers()
    }

    override suspend fun getStudents(): Flow<List<User>> {
        return dataLocalSource.getStudents()
    }

    override suspend fun addTeacher(request: AddTeacherRequest): Resource<Boolean> {
        return dataLocalSource.addTeacher(request)
    }
}