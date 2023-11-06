package com.example.roomtest.di

import android.content.Context
import com.example.roomtest.room.savedUser.SavedUserDao
import com.example.roomtest.room.savedUser.SavedUserDatabase
import com.example.roomtest.room.users.UsersDao
import com.example.roomtest.room.users.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideSavedUserDatabase(@ApplicationContext context: Context): SavedUserDatabase {
        return SavedUserDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun getSavedUserDao(database: SavedUserDatabase): SavedUserDao {
        return database.savedUserDao()
    }

    @Singleton
    @Provides
    fun getUserDatabase(@ApplicationContext context : Context):UsersDatabase{
        return UsersDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun getUserDao(database: UsersDatabase):UsersDao{
        return database.usersDao()
    }

}