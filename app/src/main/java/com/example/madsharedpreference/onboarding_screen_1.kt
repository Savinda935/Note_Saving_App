package com.example.madsharedpreference

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class onboarding_screen_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_screen1)

        val buttonNavigate=findViewById<Button>(R.id.nextButton)
        buttonNavigate.setOnClickListener{
            val intent= Intent(this,onboarding_screen_2::class.java)
            startActivity(intent)
        }

    }
}