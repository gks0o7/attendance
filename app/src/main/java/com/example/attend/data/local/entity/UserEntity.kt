package com.example.attend.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id :Long = 0,
    val username: String,
    val name: String,
    val password: String,
    val role: String
)