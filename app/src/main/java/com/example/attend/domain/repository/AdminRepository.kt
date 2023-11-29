package com.example.attend.domain.repository

import com.example.attend.common.Resource
import com.example.attend.data.local.request.AddTeacherRequest
import com.example.attend.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AdminRepository {
    suspend fun getTeachers(): Flow<List<User>>

    suspend fun getStudents(): Flow<List<User>>

    suspend fun addTeacher(request: AddTeacherRequest): Resource<Boolean>
}