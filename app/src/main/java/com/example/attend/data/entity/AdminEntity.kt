package com.example.attend.data.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admin")
data class AdminEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "admin_id")
    val adminId: Long = 0,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "created_at")
    val createdAt: Long // Assuming a timestamp in milliseconds
)
