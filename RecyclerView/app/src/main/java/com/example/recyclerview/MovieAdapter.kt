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
        val movieView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent, false
            )

        return MovieViewHolder(movieView)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
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
    private val id: TextView = itemView.findViewById(R.id.movie_id)
    private val year: TextView = itemView.findViewById(R.id.movie_year)
    private val grade: TextView = itemView.findViewById(R.id.movie_grade)
    private val actors: TextView = itemView.findViewById(R.id.actors)

    fun bind(movie: Movie) {
        title.text = movie.name
        actors.text = movie.actors
        image.setImageResource(movie.image)
        id.text = movie.id.toString()
        year.text = movie.year.toString()
        grade.text = movie.grade.toString()
    }
}