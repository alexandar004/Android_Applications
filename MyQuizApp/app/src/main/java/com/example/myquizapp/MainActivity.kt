package com.example.myquizapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout

var numberQuestion = 0
var correctAnswer = 0
const val ARG_CORRECT_ANSWERS = "arg_correct_quest"
const val ARG_QUESTION = "arg_question"
val bundle = Bundle()

class MainActivity : AppCompatActivity() {

    private lateinit var firstQuestionFragment: FirstQuestionFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstQuestionFragment = FirstQuestionFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_contain, firstQuestionFragment)
            .commit()

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        drawerLayout = DrawerLayout(findViewById(R.id.drawer_layout))
//
//        actionBarDrawerToggle =
//            ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close)
//
//        actionBarDrawerToggle.isDrawerIndicatorEnabled
//
//        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//        actionBarDrawerToggle.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
//    }
}