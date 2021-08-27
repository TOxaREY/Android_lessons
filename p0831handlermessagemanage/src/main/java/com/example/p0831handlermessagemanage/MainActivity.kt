package com.example.p0831handlermessagemanage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    lateinit var h: Handler
    val hc = object : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            Log.i(LOG_TAG, "what = " + msg.what)
            return false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        h = Handler(hc)
        sendMessages()
    }

    fun sendMessages() {
        Log.i(LOG_TAG, "send messages")
        h.sendEmptyMessageDelayed(1, 1000)
        h.sendEmptyMessageDelayed(2, 2000)
        h.sendEmptyMessageDelayed(3, 3000)
        h.removeMessages(2)
    }
}