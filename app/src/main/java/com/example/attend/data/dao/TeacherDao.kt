package com.example.attend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.attend.data.entity.TeacherEntity

@Dao
interface TeacherDao {
    @Insert
    suspend fun insertTeacher(teacher: TeacherEntity)

    @Query("SELECT * FROM teacher WHERE username = :username")
    suspend fun getTeacherByUsername(username: String): TeacherEntity?

    // Add other queries or operations as needed
}
