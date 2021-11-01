package com.example.exerciseintentandlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var txtUsername: EditText? = null
    private var txtPass: EditText? = null
    private var btnSubmit: Button? = null
    private val validUsername = "Gosho@vratsasoftware.com"
    private val validPassword = "GoshkoLoshko123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViews()
        setOnClickListeners()
    }

    fun getViews() {
        txtUsername = findViewById(R.id.txt_username)
        txtPass = findViewById(R.id.txt_pass)
        btnSubmit = findViewById(R.id.btn_submit)
    }

    private fun setOnClickListeners() {
        btnSubmit?.setOnClickListener((View.OnClickListener {
            isValidUsername("Gosho@vratsasoftware.com")
            isValidPassword("GoshkoLoshko123")
            goToNextScreen(username = validUsername)
        }))
    }

    private fun isValidUsername(username: String): Boolean {

        return username == validUsername
    }

    private fun isValidPassword(password: String): Boolean {
        return password.equals(validPassword)
    }

    private fun goToNextScreen(username: String) {
        val intent = Intent(this, WelcomeUsernameActivity::class.java)
        intent.putExtra("key", username)
        startActivity(intent)
    }
}