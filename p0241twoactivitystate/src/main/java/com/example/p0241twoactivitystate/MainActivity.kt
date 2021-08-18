package com.example.p0241twoactivitystate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val TAG = "States"
    }
    lateinit var btnActTwo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnActTwo = findViewById(R.id.btnActTwo)
        btnActTwo.setOnClickListener(this)
        Log.i(TAG, "MainActivity: onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "MainActivity: onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "MainActivity: onRestart()")
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ActivityTwo::class.java)
        startActivity(intent)
    }
}