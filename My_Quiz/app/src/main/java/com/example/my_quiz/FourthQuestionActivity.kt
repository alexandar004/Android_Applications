package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class FourthQuestionActivity : BaseActivity() {
    private var btnSubmit: Button? = null
    private val CORRECT_ANSWER = "yes"
    val name = intent.getStringExtra("nickname")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_question)
    }

    override fun setClickListeners() {
        btnSubmit?.setOnClickListener {
            if (name == CORRECT_ANSWER) {
                correctAnswers++
                goToNextScreen()
            } else {
                goToNextScreen()
            }
        }
    }

    override fun goToNextScreen() {
        val intent = Intent(this, GameOverActivity::class.java)
        startActivity(intent)
    }
}