package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val name = findViewById<EditText>(R.id.name)//declarations
        val studentNumber = findViewById<EditText>(R.id.StudentNumber)
        val start = findViewById<Button>(R.id.startbutton)
        val exit = findViewById<Button>(R.id.exitbutton)

        start.setOnClickListener(){//start button to MainActivity
            Log.v("name","Welcome $name")
            Log.v("Student Number","This is $studentNumber")
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        exit.setOnClickListener(){//button to leave the app
            finish()
        }
    }
}