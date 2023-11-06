package com.example.roomtest.room.chatRecord

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomtest.room.chatRecord.ChatRecord
import kotlinx.coroutines.flow.Flow
@Dao
interface ChatRecordDao {
    @Insert
    fun insertRecord(chatRecord: ChatRecord):Long

    @Query("SELECT * FROM chat_records WHERE sender = :sender OR receiver = :receiver ORDER BY time ASC")
    fun getChatRecords(sender: String, receiver: String): Flow<List<ChatRecord>>

    @Delete
    fun deleteRecord(chatRecord: ChatRecord)

    @Query("SELECT sender FROM chat_records ORDER BY time DESC")
    fun messageList():List<String>

    @Query("DELETE FROM chat_records")
    fun deleteAll()
}