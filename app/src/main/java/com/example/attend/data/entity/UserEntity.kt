package com.example.attend.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val username: String,
    val name: String,
    val password: String,
    val role: String
)