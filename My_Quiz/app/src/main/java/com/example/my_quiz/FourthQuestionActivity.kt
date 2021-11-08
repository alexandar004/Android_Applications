package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FourthQuestionActivity : BaseActivity() {

    private var btnSubmit: Button? = null
    private val validAnswer = "yes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_question)
        getArgs()
        btnSubmit = findViewById(R.id.btn_submit)
        setClickListeners()
    }

    override fun setClickListeners() {
        btnSubmit?.setOnClickListener {
            goToNextScreen(validAnswer)
            numberOfQuestions++
            correctAnswers++
        }
    }

    private fun goToNextScreen(yourAnswer: String) {
        val intent = Intent(this, FifthQuestionActivity::class.java)
        intent.putExtra("key", yourAnswer)
            .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
            .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
        startActivity(intent)
    }
}