package com.example.p0611alertdialogprepare

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
        const val DIALOG = 1
        val sdf = SimpleDateFormat("HH:mm:ss")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onclick(v: View) {
        showDialog(DIALOG)
    }

    override fun onCreateDialog(id: Int): Dialog {
        Log.i(LOG_TAG, "onCreateDialog")
        if (id == DIALOG) {
            val adb = AlertDialog.Builder(this)
            adb.setTitle("Текущее время")
            adb.setMessage(sdf.format(Date(System.currentTimeMillis())))
            return adb.create()
        }
        return super.onCreateDialog(id)
    }

    override fun onPrepareDialog(id: Int, dialog: Dialog?) {
        super.onPrepareDialog(id, dialog)
        Log.i(LOG_TAG, "onPrepareDialog")
        if (id == DIALOG) run {
            (dialog as AlertDialog).setMessage(sdf.format(Date(System.currentTimeMillis())))
        }
    }
}