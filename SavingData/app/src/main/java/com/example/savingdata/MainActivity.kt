package com.example.savingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.savingdata.data.fragments.AllMovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var  allMovieFragment: AllMovieFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allMovieFragment = AllMovieFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.navHostFragment, allMovieFragment)
            .commit()
    }
}