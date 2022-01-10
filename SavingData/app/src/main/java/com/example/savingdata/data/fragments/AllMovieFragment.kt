package com.example.savingdata.data.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.savingdata.R
import com.example.savingdata.data.MovieAdapter
import com.example.savingdata.data.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllMovieFragment : Fragment() {

    private lateinit var btnAddMovie: Button
    private lateinit var movieService: MovieService
    private lateinit var activityListener: ActivityListener
    private var adapter = MovieAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityListener = context as ActivityListener
        } catch (e: ClassCastException) {
            Log.e("ASD", "cannot cast")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_all_movie, container, false)

        btnAddMovie = view.findViewById(R.id.go_to_add_movie)

        btnAddMovie.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_add_movie_fragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieService = MovieService(context)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        loadMovie()

        activityListener.doSomething()
    }

    private fun loadMovie() {
        with(movieService) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                getAllMovie()
            }
        }
    }

}

interface ActivityListener {
    fun doSomething()
}