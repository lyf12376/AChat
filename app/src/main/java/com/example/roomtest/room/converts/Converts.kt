package com.example.roomtest.room.converts

import androidx.room.TypeConverter
import java.sql.Timestamp

class Converts {
    @TypeConverter
    fun timestampToLong(timestamp: Timestamp):Long?{
        return timestamp?.time
    }
}