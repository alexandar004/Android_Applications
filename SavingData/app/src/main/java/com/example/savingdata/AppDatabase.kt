package com.example.savingdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.savingdata.data.Movie

private const val DATABASE_NAME = "com.vsc.myapp.database"


@Database(entities = [(Movie::class)], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract var movieDao: MovieDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as AppDatabase
        }
    }

//    companion object {
//    companion object {
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            val tempInstance = instance
//
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val INSTANCE = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    DATABASE_NAME
//                ).build()
//                instance = INSTANCE
//                return INSTANCE
//            }
//        }
//    }
}