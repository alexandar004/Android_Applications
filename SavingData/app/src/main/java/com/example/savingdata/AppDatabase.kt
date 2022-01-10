package com.example.savingdata

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.savingdata.data.Movie


@Database(entities = [(Movie::class)], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract var movieDao: MovieDao
}