package com.example.p0811handlersimplemessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
        const val STATUS_NONE = 0
        const val STATUS_CONNECTING = 1
        const val STATUS_CONNECTED = 2
    }
    lateinit var h: Handler
    lateinit var tvStatus: TextView
    lateinit var pbConnect: ProgressBar
    lateinit var btnConnect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStatus = findViewById(R.id.tvStatus)
        pbConnect = findViewById(R.id.pbConnect)
        btnConnect = findViewById(R.id.btnConnect)
        h = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    STATUS_NONE -> {
                        btnConnect.isEnabled = true
                        tvStatus.text = "Not connected"
                    }
                    STATUS_CONNECTING -> {
                        btnConnect.isEnabled = false
                        pbConnect.isVisible = true
                        tvStatus.text = "Connecting"
                    }
                    STATUS_CONNECTED -> {
                        pbConnect.isVisible = false
                        tvStatus.text = "Connected"
                    }
                }
            }
        }
        h.sendEmptyMessage(STATUS_NONE)
    }
    fun onclick(v: View) {
        val t = Thread(Runnable {
            kotlin.run {
                try {
                    h.sendEmptyMessage(STATUS_CONNECTING)
                    TimeUnit.SECONDS.sleep(2)
                    h.sendEmptyMessage(STATUS_CONNECTED)
                    TimeUnit.SECONDS.sleep(3)
                    h.sendEmptyMessage(STATUS_NONE)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        })
        t.start()
    }
}