package com.example.attend.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "combined_record")
data class AttendanceEntity(
    @PrimaryKey(autoGenerate = true)
    val recordId: Long = 0,
    val classId: Long,
    val studentId: Long,
    val date: String,  // Date field to represent both class schedule and attendance date
    val dayOfWeek: String,  // Day of the week
    val startTime: String,
    val endTime: String,
    val status: String
)
