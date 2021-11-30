package com.example.myquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getArgs()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_over, container, false)
        val txtPoints: TextView = view.findViewById(R.id.point)
        val txtQuest: TextView = view.findViewById(R.id.questions)

        txtPoints.text = "Points: $correctAnswer"
        txtQuest.text = "Number Of Question: $numberQuestion"
        return view
    }

    private fun getArgs() {
        val bundle = this.arguments
        if (bundle != null) {
            correctAnswer = bundle.getInt(ARG_CORRECT_ANSWERS)
            numberQuestion = bundle.getInt(ARG_QUESTION)
        }
    }
}