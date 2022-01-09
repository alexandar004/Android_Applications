package com.example.savingdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.savingdata.data.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies" )
     fun getAll(): List<Movie>

    @Insert
    fun insertMovie(vararg movie: Movie)
}