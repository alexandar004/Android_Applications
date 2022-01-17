package com.example.savingdata.data.fragments

//import com.example.savingdata.data.MovieAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.savingdata.R
import com.example.savingdata.data.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllMovieFragment : Fragment() {

    private lateinit var btnAddMovie: Button
    private lateinit var movieService: MovieService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_all_movie, container, false)

        btnAddMovie = view.findViewById(R.id.go_to_add_movie)

        btnAddMovie.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_add_movie_fragment)
        }

        movieService = MovieService.getInstance(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        movieService = MovieService(context)
//            movieService = MovieService(context)


        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)

//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.adapter = adapter

        loadMovie()
    }

    private fun loadMovie() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            movieService.getAllMovie()
        }
    }


}
//        fun getInstance(context: Context): AppDatabase {
//            if (instance == null) {
//                instance = AppDatabase.getInstance(context)
//            }
//            return instance as AppDatabase
//        }