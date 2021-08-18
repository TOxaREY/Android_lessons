package com.example.p0231oneactivitystate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "States"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}