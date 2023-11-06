package com.example.roomtest.room.chatRecord

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ChatRecord::class], version = 1, exportSchema = false)
abstract class ChatRecordDatabase : RoomDatabase() {
    abstract fun chatRecordDao(): ChatRecordDao

    companion object {
        @Volatile
        private var INSTANCE: ChatRecordDatabase? = null

        fun getDatabase(context: Context): ChatRecordDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ChatRecordDatabase::class.java,
                    "chat_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
