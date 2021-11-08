package com.example.my_quiz

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    var correctAnswers = 0
    var numberOfQuestions = 0

    lateinit var btnYes: Button
    lateinit var btnNo: Button

    abstract fun setClickListeners()

    fun getArgs() {
        val extras = intent.extras
        if (extras != null) {
            correctAnswers = extras.getInt(Constants.ARG_CORRECT_ANSWERS)
            numberOfQuestions = extras.getInt(Constants.ARG_QUESTION)
        }
    }
}