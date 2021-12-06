package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList: MutableList<Movie> = mutableListOf()
    private lateinit var movieGenerator: MovieGenerator

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie,
            parent, false
        )

        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        movieGenerator.generateMovieList()
        val movie = movieList[position]
        holder.bind(movie)
    }

    fun setItems(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.movie_image)
    private val title: TextView = itemView.findViewById(R.id.movie_title)
//    val id: TextView = itemView.findViewById(R.id.movie_id)
//    val year: TextView = itemView.findViewById(R.id.movie_year)
//    val grade: TextView = itemView.findViewById(R.id.movie_grade)

        fun bind(movie: Movie) {
        title.text = movie.name
    }
}