package com.example.my_quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton

class FifthQuestionActivity : BaseActivity() {

    private lateinit var btnColorRed: RadioButton
    private lateinit var btnColorYellow: RadioButton
    private lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_question_activiry)
        getArgs()
        btnColorRed = findViewById(R.id.red_color)
        btnColorYellow = findViewById(R.id.yellow_color)
        btnSubmit = findViewById(R.id.btn_submit)
        setClickListeners()
    }

    fun onClick(view: View) {
        if (view is RadioButton) {
            val option = view.isChecked
            when (view.getId()) {
                R.id.yellow_color ->
                    if (option) {
                        btnSubmit.setOnClickListener {
                            val intent = Intent(this, GameOverActivity::class.java)
                                .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
                                .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
                            startActivity(intent)
                            numberOfQuestions++
                        }
                    }
                R.id.red_color ->
                    if (option) {
                        btnSubmit.setOnClickListener {
                            val intent = Intent(this, GameOverActivity::class.java)
                                .putExtra(Constants.ARG_QUESTION, numberOfQuestions)
                                .putExtra(Constants.ARG_CORRECT_ANSWERS, correctAnswers)
                            startActivity(intent)
                            correctAnswers++
                            numberOfQuestions++
                        }
                    }
            }
        }
    }

    override fun setClickListeners() {}

}