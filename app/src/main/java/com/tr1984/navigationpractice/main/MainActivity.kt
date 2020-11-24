package com.tr1984.navigationpractice.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
                .run {
                    setContentView(root)
                    bottomNavigation.setupWithNavController(findNavController(R.id.nav_host))
                }
    }
}