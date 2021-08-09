package com.example.p0111resvalues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llBottom: LinearLayout = findViewById(R.id.llBottom)
        val tvBottom: TextView = findViewById(R.id.tvBottom)
        val btnBottom: Button = findViewById(R.id.btnBottom)

        llBottom.setBackgroundResource(R.color.llBottomColor)
        tvBottom.setText(R.string.tvBottomText)
        btnBottom.setText(R.string.btnBottomText)
    }
}