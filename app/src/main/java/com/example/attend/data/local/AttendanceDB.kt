package com.example.attend.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.attend.data.local.dao.UserDao
import com.example.attend.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AttendanceDB : RoomDatabase() {

    abstract fun userDao(): UserDao

}