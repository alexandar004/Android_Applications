package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameOverActivity : BaseActivity() {
    private lateinit var point: TextView
    private lateinit var quest: TextView
    private lateinit var playAgainButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        getArgs()
        playAgainButton = findViewById(R.id.play_again)
        point = findViewById(R.id.point)
        quest = findViewById(R.id.quest)
        setClickListeners()
        printPoints()
    }

    override fun setClickListeners() {
        playAgainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
                .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
            startActivity(intent)
            numberOfQuestions++
        }
    }

    private fun printPoints() {
        point.text = correctAnswers.toString()
        quest.text = numberOfQuestions.toString()
    }
}