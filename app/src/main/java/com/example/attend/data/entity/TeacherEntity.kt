package com.example.attend.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher")
data class TeacherEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "teacher_id")
    val teacherId: Long = 0,

    @ColumnInfo(name = "admin_id")
    val adminId: Long,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "created_at")
    val createdAt: String // Assuming createdAt is stored as a string for simplicity
)
