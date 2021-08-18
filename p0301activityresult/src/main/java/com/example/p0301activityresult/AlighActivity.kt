package com.example.p0301activityresult

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button

class AlighActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnLeft: Button
    lateinit var btnCenter: Button
    lateinit var btnRight: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aligh)

        btnLeft = findViewById(R.id.btnLeft)
        btnCenter = findViewById(R.id.btnCenter)
        btnRight = findViewById(R.id.btnRight)

        btnLeft.setOnClickListener(this)
        btnCenter.setOnClickListener(this)
        btnRight.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when (v?.id) {
            R.id.btnLeft -> intent.putExtra("alignment", Gravity.LEFT)
            R.id.btnCenter -> intent.putExtra("alignment", Gravity.CENTER)
            R.id.btnRight -> intent.putExtra("alignment", Gravity.RIGHT)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}