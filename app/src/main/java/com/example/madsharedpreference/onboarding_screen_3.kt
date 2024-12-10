package com.example.madsharedpreference

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class onboarding_screen_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen3)

        val buttonNavigate=findViewById<Button>(R.id.getStartedButton)
        buttonNavigate.setOnClickListener{
            val intent= Intent(this,stopwach::class.java)
            startActivity(intent)
        }
    }
}