package com.example.myquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation


class SecondQuestionFragment : Fragment() {

    private lateinit var btnSubmit: Button
    private val validAnswer = "yes"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getArgs()

        val view = inflater.inflate(R.layout.fragment_second_question, container, false)
        val btnSubmit: Button = view.findViewById(R.id.btn_submit)
        val editText: EditText = view.findViewById(R.id.your_answer)

        btnSubmit.setOnClickListener {
            val input = editText.text.toString()

            if (input == validAnswer) {
                putBundle()
                correctAnswer++
                numberQuestion++
                Navigation.findNavController(view)
                    .navigate(R.id.action_secondQuestion_to_third_question)
            }
            putBundle()
            numberQuestion++
            Navigation.findNavController(view)
                .navigate(R.id.action_secondQuestion_to_third_question)
        }
        return view
    }

    private fun putBundle() {
        bundle.putInt(ARG_QUESTION, numberQuestion)
        bundle.putInt(ARG_CORRECT_ANSWERS, correctAnswer)
        val fragment = ThirdQuestionFragment()
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