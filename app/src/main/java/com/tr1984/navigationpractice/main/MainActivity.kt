package com.tr1984.navigationpractice.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {

        }.run {
            setContentView(root)

            val navController = findNavController(R.id.nav_host)
            setupActionBarWithNavController(navController, AppBarConfiguration(setOf(R.id.menu_home, R.id.menu_best, R.id.menu_hot)))
            bottomNavigation.setupWithNavController(navController)
        }
    }
}