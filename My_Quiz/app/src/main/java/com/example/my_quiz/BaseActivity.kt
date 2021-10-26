package com.example.my_quiz

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    var correctAnswers = 0
    var numberOfQuestions = 0
    lateinit var btnYes: Button
    lateinit var btnNo: Button


    protected open fun goToNextScreen() {
        val intent = Intent(this, SecondQuestionsActivity::class.java)
        startActivity(intent)
    }

    protected open fun setClickListeners() {
        btnYes.setOnClickListener {
            goToNextScreen()
        }
        btnNo.setOnClickListener {
            correctAnswers++
            goToNextScreen()
        }
    }
}