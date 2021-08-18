package com.example.p0271getintentaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)

        val intent = intent
        val action = intent.action
        var format = ""
        var textInfo = ""

        if (action.equals("com.example.intent.action.showtime")) {
            format = "HH:mm:ss"
            textInfo = "Time: "
        }
        else if (action.equals("com.example.intent.action.showdate")) {
            format = "dd.MM.yyyy"
            textInfo = "Date: "
        }

        val sdf = SimpleDateFormat(format)
        val datetime = sdf.format(Date(System.currentTimeMillis()))

        val tvDate: TextView = findViewById(R.id.tvInfo)
        tvDate.text = textInfo + datetime
    }
}