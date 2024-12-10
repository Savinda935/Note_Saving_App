package com.example.madsharedpreference

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage)

        val buttonNavigate=findViewById<Button>(R.id.Start)
        buttonNavigate.setOnClickListener{
            val intent=Intent(this,onboarding_screen_1::class.java)
            startActivity(intent)
        }

    }
}