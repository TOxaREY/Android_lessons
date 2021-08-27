package com.example.p0821handleradvmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
        const val STATUS_NONE = 0
        const val STATUS_CONNECTING = 1
        const val STATUS_CONNECTED = 2
        const val STATUS_DOWNLOAD_START = 3
        const val STATUS_DOWNLOAD_FILE = 4
        const val STATUS_DOWNLOAD_END = 5
        const val STATUS_DOWNLOAD_NONE = 6
    }
    lateinit var h: Handler
    lateinit var tvStatus: TextView
    lateinit var pbDownload: ProgressBar
    lateinit var btnConnect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStatus = findViewById(R.id.tvStatus)
        pbDownload = findViewById(R.id.pbDownload)
        btnConnect = findViewById(R.id.btnConnect)
        h = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    STATUS_NONE -> {
                        btnConnect.isEnabled = true
                        tvStatus.text = "Not connected"
                        pbDownload.isVisible = false
                    }
                    STATUS_CONNECTING -> {
                        btnConnect.isEnabled = false
                        tvStatus.text = "Connecting"
                    }
                    STATUS_CONNECTED -> tvStatus.text = "Connected"
                    STATUS_DOWNLOAD_START -> {
                        tvStatus.text = "Start download " + msg.arg1.toString() + " files"
                        pbDownload.max = msg.arg1
                        pbDownload.progress = 0
                        pbDownload.isVisible = true
                    }
                    STATUS_DOWNLOAD_FILE -> {
                        tvStatus.setText("Downloading. Left " + msg.arg2.toString() + " files")
                        pbDownload.progress = msg.arg1
                        saveFile(msg.obj as ByteArray)
                    }
                    STATUS_DOWNLOAD_END -> tvStatus.text = "Download complete!"
                    STATUS_DOWNLOAD_NONE -> tvStatus.text = "No files for download"
                }
            }
        }
        h.sendEmptyMessage(STATUS_NONE)
    }

    fun onclick(v: View) {
        val t = Thread(Runnable {
            var msg: Message
            var file: ByteArray
            val rand = Random()
            kotlin.run {
                try {
                    h.sendEmptyMessage(STATUS_CONNECTING)
                    TimeUnit.SECONDS.sleep(1)

                    h.sendEmptyMessage(STATUS_CONNECTED)

                    TimeUnit.SECONDS.sleep(1)
                    val fileCount = rand.nextInt(5)

                    if (fileCount == 0) {
                        h.sendEmptyMessage(STATUS_DOWNLOAD_NONE)
                        TimeUnit.MILLISECONDS.sleep(1500)
                        h.sendEmptyMessage(STATUS_NONE)
                    }
                    msg = h.obtainMessage(STATUS_DOWNLOAD_START, fileCount, 0)
                    h.sendMessage(msg)

                    for (i in 1..fileCount) {
                        file = downloadFile()
                        msg = h.obtainMessage(STATUS_DOWNLOAD_FILE, i, fileCount - 1, file)
                        h.sendMessage(msg)
                    }
                    h.sendEmptyMessage(STATUS_DOWNLOAD_END)
                    TimeUnit.MILLISECONDS.sleep(1500)
                    h.sendEmptyMessage(STATUS_NONE)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        })
        t.start()
    }

    fun downloadFile(): ByteArray {
        TimeUnit.SECONDS.sleep(2)
        return ByteArray(1024)
    }

    fun saveFile(file: ByteArray) {

    }
}