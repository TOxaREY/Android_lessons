package com.example.p0211twoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnActTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnActTwo = findViewById(R.id.btnActTwo)
        btnActTwo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnActTwo -> {
                var intent = Intent(this,ActivityTwo::class.java)
                startActivity(intent)
            }
        }
    }
}