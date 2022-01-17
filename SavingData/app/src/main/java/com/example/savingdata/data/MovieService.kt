package com.example.savingdata.data

import android.content.Context
import com.example.savingdata.AppDatabase
import com.example.savingdata.MovieDao

class MovieService
    (context: Context) {

    private lateinit var movieDao: MovieDao

    init {

         movieDao: MovieDao = AppDatabase.getInstance(context).movieDao

    }

    companion object {

        private var instance: MovieService? = null

        fun getInstance(context: Context): MovieService {
            if (instance == null) {
                instance = MovieService(context)
            }
            return instance as MovieService
        }
    }

    suspend fun getAllMovie() {
        movieDao.getAll()
    }

    suspend fun addMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }
}