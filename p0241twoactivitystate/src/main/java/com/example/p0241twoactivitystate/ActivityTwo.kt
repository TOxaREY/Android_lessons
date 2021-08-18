package com.example.p0241twoactivitystate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityTwo : AppCompatActivity() {

    companion object {
        const val TAG = "States"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two)
        Log.i(TAG, "ActivityTwo: onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "ActivityTwo: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "ActivityTwo: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "ActivityTwo: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "ActivityTwo: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "ActivityTwo: onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(MainActivity.TAG, "ActivityTwo: onRestart()")
    }
}