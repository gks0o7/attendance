package com.example.attend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.attend.data.entity.AdminEntity


@Dao
interface AdminDao {
    @Insert
    fun insertAdmin(admin: AdminEntity)

    @Query("SELECT * FROM admin WHERE username = :username AND password = :password")
    fun getAdminByUsernameAndPassword(username: String, password: String): AdminEntity?

    // Add other queries as needed
}
