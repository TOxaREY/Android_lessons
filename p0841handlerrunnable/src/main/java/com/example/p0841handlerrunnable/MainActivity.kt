package com.example.p0841handlerrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
        const val max = 100
    }
    lateinit var h: Handler
    lateinit var pbCount: ProgressBar
    lateinit var tvInfo: TextView
    lateinit var chbInfo: CheckBox
    var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        h = Handler()

        pbCount = findViewById(R.id.pbCount)
        pbCount.max = max
        pbCount.progress = 0

        tvInfo = findViewById(R.id.tvInfo)

        chbInfo = findViewById(R.id.chbInfo)
        chbInfo.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                tvInfo.isVisible = true
                h.post(showInfo)
            } else {
                tvInfo.isVisible = false
                h.removeCallbacks(showInfo)
            }
        }
        val t = Thread(Runnable {
            kotlin.run {
                try {
                    for (cnt in 1..max - 1) {
                        TimeUnit.MILLISECONDS.sleep(100)
                        h.post(updateProgress)
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        })
        t.start()
    }
    val uppdateProgress = Runnable {
        kotlin.run {
            pbCount.progress = cnt
        }
    }
    val showInfo = Runnable {
        kotlin.run {
            Log.i(LOG_TAG, "showInfo")
            tvInfo.text = "Count = " + cnt
            h.postDelayed(showInfo, 1000)
        }
    }
}