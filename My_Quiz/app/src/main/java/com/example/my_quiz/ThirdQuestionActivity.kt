package com.example.my_quiz

import android.content.Intent
import android.os.Bundle

class ThirdQuestionActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_question)
        goToNextScreen()
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
        val intent = Intent(this, FourthQuestionActivity::class.java)
        startActivity(intent)
    }
}