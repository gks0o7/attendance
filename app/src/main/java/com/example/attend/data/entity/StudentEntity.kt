package com.example.attend.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    val studentId: Long = 0L,

    val teacherId: Long, // Foreign key referencing the teacher table
    val username: String,
    val password: String,
    val email: String,
    val createdAt: Long // You may want to use Date type or another appropriate type
)
