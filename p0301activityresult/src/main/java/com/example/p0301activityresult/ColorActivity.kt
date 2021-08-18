package com.example.p0301activityresult

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ColorActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnRed: Button
    lateinit var btnGreen: Button
    lateinit var btnBlue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color)

        btnRed = findViewById(R.id.btnRed)
        btnGreen = findViewById(R.id.btnGreen)
        btnBlue = findViewById(R.id.btnBlue)

        btnRed.setOnClickListener(this)
        btnGreen.setOnClickListener(this)
        btnBlue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when (v?.id) {
            R.id.btnRed -> intent.putExtra("color", Color.RED)
            R.id.btnGreen -> intent.putExtra("color", Color.GREEN)
            R.id.btnBlue -> intent.putExtra("color", Color.BLUE)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}