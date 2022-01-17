package com.example.savingdata.data.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.savingdata.R
import com.example.savingdata.data.Movie
import com.example.savingdata.data.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMovieFragment : Fragment() {

    private lateinit var edtTitle: EditText
    private lateinit var edtYear: EditText
    private lateinit var edtGrade: EditText
    private lateinit var btnSave: Button

    private lateinit var movieService: MovieService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_movie, container, false)

//        movieService = MovieService(requireContext())

        edtTitle = view.findViewById(R.id.movie_title)
        edtYear = view.findViewById(R.id.movie_year)
        edtGrade = view.findViewById(R.id.edt_grade)
        btnSave = view.findViewById(R.id.btn_save)

        setClickListeners()

        return view
    }

    private fun setClickListeners() {
        btnSave.setOnClickListener {
            val name = edtTitle.text.toString()
            val year = edtYear.toString()
            val grade = edtGrade

            val movie = Movie(title = name, year = year, grade = grade)

            with(movieService) {
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                    addMovie(movie)
                }

            }

            edtTitle.setText("")
            edtYear.setText("")
            edtGrade.setText("")

            findNavController().navigate(R.id.action_add_movie_fragment_to_home_fragment)
        }
    }
}