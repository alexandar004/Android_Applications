package com.example.my_quiz

import android.os.Bundle
import android.widget.TextView

class GameOverActivity : BaseActivity() {
    private lateinit var printPoints: TextView
    var allCorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        printAllPoints()
    }

    private fun printAllPoints() {
        allCorrectAnswers += correctAnswers
        println("Your points: $allCorrectAnswers")
    }
}