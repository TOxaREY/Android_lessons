package com.example.p0271getintentaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnTime: Button = findViewById(R.id.btnTime)
        var btnDate: Button = findViewById(R.id.btnDate)

        btnTime.setOnClickListener(this)
        btnDate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent: Intent

        when (v?.id) {
            R.id.btnTime -> {
                intent = Intent("com.example.intent.action.showtime")
                startActivity(intent)
            }
            R.id.btnDate -> {
                intent = Intent("com.example.intent.action.showdate")
                startActivity(intent)
            }
        }
    }
}