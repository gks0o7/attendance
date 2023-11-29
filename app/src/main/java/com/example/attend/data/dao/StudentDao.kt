package com.example.attend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.attend.data.entity.StudentEntity

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: StudentEntity)

    @Query("SELECT * FROM student WHERE username = :username")
    suspend fun getStudentByUsername(username: String): StudentEntity?

    // Add other queries or operations as needed
}
