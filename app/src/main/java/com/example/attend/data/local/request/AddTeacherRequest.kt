package com.example.attend.data.local.request

import com.example.attend.Const.TEACHER

data class AddTeacherRequest(
    val name: String,
    val username: String,
    val password: String,
    val role: String = TEACHER
)