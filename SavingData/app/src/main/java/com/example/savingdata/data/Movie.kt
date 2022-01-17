package com.example.savingdata.data

import android.widget.EditText
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "Title") val title: String,

    @ColumnInfo(name = "Year") val year: String,

    @ColumnInfo(name = "Grade") val grade: EditText

)