package com.example.attend.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.attend.data.entity.AttendanceEntity

@Dao
interface CombinedRecordDao {

    @Insert
    suspend fun insertRecord(record: AttendanceEntity)

    @Query("SELECT * FROM combined_record WHERE classId = :classId AND date = :date")
    suspend fun getRecordsForClassAndDate(classId: Long, date: String): List<AttendanceEntity>

    // Add other queries as needed based on your requirements

}
