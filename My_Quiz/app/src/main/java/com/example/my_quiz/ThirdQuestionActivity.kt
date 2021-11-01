package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class ThirdQuestionActivity : BaseActivity() {
    private lateinit var thirdQuestion: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_question)
        getArgs()
        btnYes = findViewById(R.id.btn_yes)
        btnNo = findViewById(R.id.btn_no)
        setClickListeners()
    }

    override fun setClickListeners() {
        btnYes.setOnClickListener {
            numberOfQuestions++
            correctAnswers++
            val intent = Intent(this, FourthQuestionActivity::class.java)
                .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
                .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
            startActivity(intent)
        }
        btnNo.setOnClickListener {
            val intent = Intent(this, FourthQuestionActivity::class.java)
                .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
                .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
            startActivity(intent)
            numberOfQuestions++
        }
    }
}