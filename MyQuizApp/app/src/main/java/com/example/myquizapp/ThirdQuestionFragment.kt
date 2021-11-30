package com.example.myquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.Navigation

class ThirdQuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getArgs()
        val view = inflater.inflate(R.layout.fragment_third_question, container, false)

        val btnSubmit: Button = view.findViewById(R.id.btn_submit)
        val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)

        btnSubmit.setOnClickListener {
            when (radioGroup.checkedRadioButtonId) {
                R.id.red_color -> {
                    putBundle()
                    correctAnswer++
                    numberQuestion++
                    Navigation.findNavController(view)
                        .navigate(R.id.action_third_question_to_gameOver)
                }
                R.id.yellow_color -> {
                    putBundle()
                    numberQuestion++
                    Navigation.findNavController(view)
                        .navigate(R.id.action_third_question_to_gameOver)
                }
            }
        }
        return view
    }

    private fun putBundle() {
        bundle.putInt(ARG_QUESTION, numberQuestion)
        bundle.putInt(ARG_CORRECT_ANSWERS, correctAnswer)
        val fragment = GameOverFragment()
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