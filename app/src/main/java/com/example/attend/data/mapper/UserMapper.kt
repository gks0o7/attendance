package com.example.attend.data.mapper

import com.example.attend.data.local.entity.UserEntity
import com.example.attend.domain.model.User

fun UserEntity.toUser(): User {
    return User(
        id = id,
        name = name,
        username = username,
        role = role
    )
}