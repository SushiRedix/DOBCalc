package com.sushi.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate : TextView? = null
    private var tvDateInMin : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val dateBtn : Button = findViewById(R.id.dateBtn)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvDateInMin = findViewById(R.id.dateInMin)

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

                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val date = sdf.parse(selectedDate)

                val selectedDateInMinutes = date.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate.time / 60000
                val dif = currentDateInMinutes - selectedDateInMinutes

                if(dif < 0) {
                    tvDateInMin?.text = "It needs to pass ${abs(dif)} minutes"
                }
                else {
                    tvDateInMin?.text = "It has passed $dif minutes"
                }
            },
            year,
            month,
            day
            ).show()
    }
}