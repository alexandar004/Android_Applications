package com.example.savingdata.data

import android.content.Context
import com.example.savingdata.MovieDao

class MovieService//Todo: не съм сигурен дали правилно създавам обекта, защото в лекцията е final
//    private final val movieDao: MovieDao? = null
    (context: Context) {

    private var movieDao: MovieDao = Database().getInstance(context).movieDao

    fun getAllMovie(dataListener: DataListener<List<Movie>>): List<Movie> {

        return movieDao.getAll()
    }

    fun addMovie(movie: Movie){
        return movieDao.insertMovie()
    }

}

interface DataListener<T> {
    fun onData(data: T) {

    }
}