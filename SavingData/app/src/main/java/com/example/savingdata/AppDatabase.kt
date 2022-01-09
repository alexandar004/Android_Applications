package com.example.savingdata

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.savingdata.data.Movie


@Database(entities = [(Movie::class)], version = 1)
abstract class AppDatabase : RoomDatabase(), MovieDao {
    abstract var movieDao: MovieDao

    //Todo не съм сигурен дали няма да даде отражение с тези методи override

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}