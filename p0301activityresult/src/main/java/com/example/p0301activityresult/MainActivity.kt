package com.example.p0301activityresult

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvText: TextView
    lateinit var btnColor: Button
    lateinit var btnAligh: Button

    companion object {
        const val REQUEST_CODE_COLOR = 1
        const val REQUEST_CODE_ALIGN = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)

        btnColor = findViewById(R.id.btnColor)
        btnColor.setOnClickListener(this)

        btnAligh = findViewById(R.id.btnAlign)
        btnAligh.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent: Intent
        when (v?.id) {
            R.id.btnColor -> {
                intent = Intent(this, ColorActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_COLOR)
            }
            R.id.btnAlign -> {
                intent = Intent(this, AlighActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_ALIGN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode)
        data ?: return
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_COLOR -> {
                    val color = data.getIntExtra("color", Color.WHITE)
                    tvText.setTextColor(color)
                }
                REQUEST_CODE_ALIGN -> {
                    val aligh = data.getIntExtra("alignment", Gravity.LEFT)
                    tvText.gravity = aligh
                }
            }
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show()
        }
    }
}