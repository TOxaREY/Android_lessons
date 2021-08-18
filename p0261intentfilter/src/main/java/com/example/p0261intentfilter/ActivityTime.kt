package com.example.p0261intentfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time)

        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(Date(System.currentTimeMillis()))

        val tvTime: TextView = findViewById(R.id.tvTime)
        tvTime.text = time
    }
}