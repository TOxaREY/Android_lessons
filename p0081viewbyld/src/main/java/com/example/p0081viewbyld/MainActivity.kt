package com.example.p0081viewbyld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myTextView: TextView = findViewById(R.id.myText)
        myTextView.text = "New text in TextView"
        val myBtn: Button = findViewById(R.id.myBtn)
        myBtn.text = "My button"
        myBtn.isEnabled = false
        val myChb: CheckBox = findViewById(R.id.myChb)
        myChb.isChecked = true
    }
}