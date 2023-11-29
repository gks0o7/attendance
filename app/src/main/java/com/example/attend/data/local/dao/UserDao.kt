package com.example.attend.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.attend.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE username=:username")
    fun getUser(username: String) : UserEntity?
}