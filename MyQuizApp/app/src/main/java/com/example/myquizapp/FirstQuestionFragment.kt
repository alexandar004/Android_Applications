package com.example.myquizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FirstQuestionFragment : Fragment(R.layout.activity_main) {

    private lateinit var btnYes: Button
    private lateinit var btnNo: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        getArgs()
        val view = inflater.inflate(R.layout.fragment_first_question, container, false)
        btnYes = view.findViewById(R.id.btn_yes)
        btnNo = view.findViewById(R.id.btn_no)

        btnYes.setOnClickListener {
            putBundle()
            Navigation.findNavController(view).navigate(R.id.action_firstQuestion_to_secondQuestion)
            numberQuestion++
            correctAnswer++
        }
        btnNo.setOnClickListener {
            putBundle()
            Navigation.findNavController(view).navigate(R.id.action_firstQuestion_to_secondQuestion)
            numberQuestion++
        }
        return view
    }


    private fun putBundle() {
        bundle.putInt(ARG_QUESTION, numberQuestion)
        bundle.putInt(ARG_CORRECT_ANSWERS, correctAnswer)
        val fragment = SecondQuestionFragment()
        fragment.arguments = bundle
    }

    private fun getArgs() {
        val bundle = this.arguments
        if (bundle != null) {
            correctAnswer = bundle.getInt(ARG_CORRECT_ANSWERS)
            numberQuestion = bundle.getInt(ARG_QUESTION)
        }
    }
}
