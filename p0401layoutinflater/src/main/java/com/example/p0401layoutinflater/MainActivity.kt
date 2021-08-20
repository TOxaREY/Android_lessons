package com.example.p0401layoutinflater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ltInflater = layoutInflater

        val linLayout = findViewById<LinearLayout>(R.id.linLayout)
        val view1 = ltInflater.inflate(R.layout.text, linLayout, true)
        val lp1 = view1.layoutParams

        Log.i(LOG_TAG, "CLass of view1: " + view1.javaClass.name.toString())
        Log.i(LOG_TAG, "CLass of layoutParams of view1: " + lp1.javaClass.name.toString())

        val reLayout = findViewById<RelativeLayout>(R.id.relLayout)
        val view2 = ltInflater.inflate(R.layout.text, reLayout, true)
        val lp2 = view2.layoutParams

        Log.i(LOG_TAG, "CLass of view2: " + view2.javaClass.name.toString())
        Log.i(LOG_TAG, "CLass of layoutParams of view2: " + lp2.javaClass.name.toString())
    }
}