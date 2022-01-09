package com.example.savingdata.data

import android.content.Context
import androidx.room.Room
import com.example.savingdata.AppDatabase

private const val DATABASE_NAME = "com.vsc.myapp.database"

final class Database() {

    private lateinit var instance: AppDatabase


    init {

    }

    fun getInstance(context: Context): AppDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }

        return instance
    }
}