package com.example.savingdata.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "Title") val title: String,

    @ColumnInfo(name = "Year") val year: String,

    @ColumnInfo(name = "Grade") val grade: Int
)