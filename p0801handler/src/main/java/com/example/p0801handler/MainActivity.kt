package com.example.p0801handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    lateinit var h: Handler
    lateinit var tvInfo: TextView
    lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInfo = findViewById(R.id.tvInfo)
        btnStart = findViewById(R.id.btnStart)
        h = object : Handler() {
            override fun handleMessage(msg: Message) {
                tvInfo.text = "Закачано файлов: " + msg.what
                if (msg.what == 10) btnStart.isEnabled = true
            }
        }
    }

    fun onclick(v: View) {
        when (v.id) {
            R.id.btnStart -> {
                btnStart.isEnabled = false
                val t = Thread(Runnable {
                    kotlin.run {
                        for (i in 1..10) {
                            downloadFile()
                            h.sendEmptyMessage(i)
                            Log.i(LOG_TAG, "i = " + i)
                        }
                    }
                })
                t.start()
            }
            R.id.btnTest -> Log.i(LOG_TAG, "test")
        }
    }
    fun downloadFile() {
        try {
            TimeUnit.SECONDS.sleep(1)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}