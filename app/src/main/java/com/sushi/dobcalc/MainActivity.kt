package com.sushi.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val dateBtn : Button = findViewById(R.id.dateBtn)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        dateBtn.setOnClickListener {
            displayCalendar()
        }
    }

    fun displayCalendar() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDay ->
                //Logic here
                Toast.makeText(this, "Datapicker works", Toast.LENGTH_LONG).show()
            },
            year,
            month,
            day
            ).show()
    }
}