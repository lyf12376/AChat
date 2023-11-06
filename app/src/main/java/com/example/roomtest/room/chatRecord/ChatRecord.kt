package com.example.roomtest.room.chatRecord

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp


@Entity(tableName = "chat_records")
data class ChatRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sender: String,
    val receiver: String,
    val message: String,
    val time: Long
)
