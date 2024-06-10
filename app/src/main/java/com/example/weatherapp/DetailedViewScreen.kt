package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailedViewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val days = intent.getStringArrayListExtra("days")?:arrayListOf()
        val minn = intent.getStringArrayListExtra("Minimum")?:arrayListOf()
        val maxx = intent.getStringArrayListExtra("Maximum")?:arrayListOf()
        val wConditions = intent.getStringArrayListExtra("Weather Conditions")
            ?:arrayListOf()//getting the arrays

        val back = findViewById<Button>(R.id.backbutton)//declarations

        back.setOnClickListener(){//button to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
