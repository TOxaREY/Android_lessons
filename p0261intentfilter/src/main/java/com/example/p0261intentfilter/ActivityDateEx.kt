package com.example.p0261intentfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityDateEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date)

        val sdf = SimpleDateFormat("EEE, MMM d, yyyy")
        val date = sdf.format(Date(System.currentTimeMillis()))

        val tvDate: TextView = findViewById(R.id.tvDate)
        tvDate.text = date
    }
}