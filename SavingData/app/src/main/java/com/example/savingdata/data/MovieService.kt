package com.example.savingdata.data

import android.content.Context
import com.example.savingdata.MovieDao

class MovieService
    (context: Context) {

    private val movieDao: MovieDao = Database().getInstance(context).movieDao

    suspend fun getAllMovie() {
        movieDao.getAll()
    }

    suspend fun addMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }
}