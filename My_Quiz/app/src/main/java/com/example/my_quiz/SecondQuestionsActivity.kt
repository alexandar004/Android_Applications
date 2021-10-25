package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class SecondQuestionsActivity : BaseActivity() {
    private var secondQuestion: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViews()
        setClickListeners()
    }

    private fun getViews() {
        secondQuestion = findViewById(R.id.second_question)
        btnYes = findViewById(R.id.btn_yes)
        btnNo = findViewById(R.id.btn_no)
    }

    override fun setClickListeners() {
        btnYes.setOnClickListener {
            correctAnswers++
            goToNextScreen()
        }
        btnNo.setOnClickListener {
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