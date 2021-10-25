package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class MainActivity : BaseActivity() {
    private var firstQuestion: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViews()
        setClickListeners()
        goToNextScreen()
    }

    private fun getViews() {
        firstQuestion = findViewById(R.id.first_question)
        btnYes = findViewById(R.id.btn_yes)
        btnNo = findViewById(R.id.btn_no)
    }

    override fun setClickListeners() {
        btnYes.setOnClickListener {
            goToNextScreen()
        }
        btnNo.setOnClickListener {
            correctAnswers++
            goToNextScreen()
        }
    }

    override fun goToNextScreen() {
        val intent = Intent(this, ThirdQuestionActivity::class.java)
            .putExtra("correctAnswer", correctAnswers.toString())
            .putExtra("quest2", numberOfQuestions.toString())
        startActivity(intent)
    }
}