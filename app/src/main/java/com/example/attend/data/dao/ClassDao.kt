package com.example.attend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClassDao {
    @Insert
    suspend fun insertClass(classEntity: ClassDao)

    @Query("SELECT * FROM class WHERE className = :className")
    suspend fun getClassByName(className: String): ClassDao?

    // Add other queries or operations as needed
}
