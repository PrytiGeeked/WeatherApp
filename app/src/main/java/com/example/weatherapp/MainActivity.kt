package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val days = ArrayList<String>()
    private val minn = ArrayList<Int>()
    private val maxx = ArrayList<Int>()
    private val wConditions = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val day = findViewById<EditText>(R.id.editTextDate)//declarations
        val min = findViewById<EditText>(R.id.editTextNumber)
        val max = findViewById<EditText>(R.id.editTextNumber2)
        val weatherConditions = findViewById<EditText>(R.id.editTextText)
        val add = findViewById<Button>(R.id.addbutton)
        val view = findViewById<Button>(R.id.viewbutton)
        val clear = findViewById<Button>(R.id.clearbutton)

        add.setOnClickListener(){//add button to add data
            val day = day.text.toString().toIntOrNull()
            val min = min.text.toString().toIntOrNull()
            val max = max.text.toString().toIntOrNull()
            val weatherConditions = weatherConditions.text.toString().toIntOrNull()

            if(day != null && min != null && max != null && weatherConditions != null){
                days.add(day.toString())
                minn.add(min)
                maxx.add(max)
                wConditions.add(weatherConditions.toString())
                Toast.makeText(this,"Data has been added", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"data is invalid",Toast.LENGTH_SHORT).show()
            }
        }
        view.setOnClickListener(){//button to enter viewScreen layout
            val intent = Intent(this,DetailedViewScreen::class.java)
            intent.putStringArrayListExtra("day", days)
            intent.putIntegerArrayListExtra("min", minn)
            intent.putIntegerArrayListExtra("max", maxx)
            intent.putStringArrayListExtra("weather Conditions", wConditions)
            startActivity(intent)
        }
        clear.setOnClickListener(){//button to clear data
            days.clear()
            minn.clear()
            maxx.clear()
            wConditions.clear()
            Toast.makeText(this,"Data has been cleared", Toast.LENGTH_SHORT).show()
            clearFields(day,min,max,weatherConditions)
        }
        //Average
        var totalTemp = 0//declarations for average
        var displayText = ""
        var average = 0
        for(i in days.indices){
            val dailyWeather = minn[i] + maxx[i]
            totalTemp += dailyWeather
            displayText += "Day:${days[i]}min:${minn[i]}max:${maxx[i]}" +
                    "weatherConditions${wConditions[i]}/n/n"
        }
        val averageTemp = if(days.isNotEmpty()){
            totalTemp/days.size//calculating average
        }else{
          println("Date is empty")
        }
    }
}
private fun clearFields(vararg fields: EditText) {//function for clear button
    for(field in fields){
        field.text.clear()
    }
}



