package com.example.attend.data.local

import com.example.attend.Const.STUDENT
import com.example.attend.Const.TEACHER
import com.example.attend.common.Resource
import com.example.attend.data.local.entity.UserEntity
import com.example.attend.data.local.request.AddTeacherRequest
import com.example.attend.data.mapper.toUser
import com.example.attend.domain.model.User
import com.example.attend.domain.repository.DataLocalSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
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


    override suspend fun getTeachers(): Flow<List<User>> {
        val data = attendanceDB.userDao().getUsers(TEACHER)

        return data.map {
            it.map(UserEntity::toUser)
        }
    }

    override suspend fun getStudents(): Flow<List<User>> {
        val data = attendanceDB.userDao().getUsers(STUDENT)

        return data.map {
            it.map(UserEntity::toUser)
        }
    }

    override suspend fun addTeacher(request: AddTeacherRequest): Resource<Boolean> {
        return try {
            val existingUserWithSameUsername = attendanceDB.userDao().getUser(request.username)
            if (existingUserWithSameUsername != null) {
                Resource.Error("username is taken")
            } else {
                val teacher = UserEntity(
                    name = request.name,
                    username = request.username,
                    role = request.role,
                    password = request.password
                )
                attendanceDB.userDao().insertOne(teacher)
                Resource.Success(true)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.localizedMessage)
        }
    }
}