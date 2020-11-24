package com.tr1984.navigationpractice.sign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tr1984.navigationpractice.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivitySignBinding.inflate(layoutInflater).root)
    }
}