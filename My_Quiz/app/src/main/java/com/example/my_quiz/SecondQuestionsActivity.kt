package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class SecondQuestionsActivity : BaseActivity() {
    private lateinit var secondQuestion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getArgs()
        btnYes = findViewById(R.id.btn_yes)
        btnNo = findViewById(R.id.btn_no)
        setClickListeners()
    }

    override fun setClickListeners() {
        btnYes.setOnClickListener {
            btnYes.setOnClickListener {
                val intent = Intent(this, ThirdQuestionActivity::class.java)
                    .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
                    .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
                startActivity(intent)
                numberOfQuestions++
            }
            btnNo.setOnClickListener {
                numberOfQuestions++
                correctAnswers++
                val intent = Intent(this, ThirdQuestionActivity::class.java)
                    .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
                    .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
                startActivity(intent)
            }
        }
    }
}