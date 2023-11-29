package com.example.attend.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "class")
data class ClassEntity(
    @PrimaryKey(autoGenerate = true)
    val classId: Long = 0,
    val teacherId: Long,
    val className: String,
    val description: String?
)
