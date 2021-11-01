package com.example.exerciseintentandlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeUsernameActivity : AppCompatActivity() {
    private lateinit var helloUsername: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_username)
        setContentView(R.layout.activity_welcome_username)

        helloUsername = findViewById(R.id.hello)
        val name = intent.getStringExtra("nickname")
        helloUsername.text = "Hello $name"
    }
}