//package com.example.savingdata.data
//
//import android.content.Context
//import androidx.room.Room
//import com.example.savingdata.AppDatabase
//
//
//class Database() :  {
//
//    private lateinit var instance: AppDatabase
//
//    init {
//
//    }
//
//    fun getInstance(context: Context): AppDatabase {
//
////        if (instance == null) {
//            instance = Room.databaseBuilder(context, AppDatabase::class.java, "DATABASE_NAME")
//                .allowMainThreadQueries()
//                .build()
////        }
//
//        return instance
//    }
//}