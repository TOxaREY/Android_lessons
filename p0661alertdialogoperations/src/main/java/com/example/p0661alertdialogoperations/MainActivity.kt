package com.example.p0661alertdialogoperations

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.DialogInterface.OnShowListener
import android.os.Handler
import android.view.View


class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
        const val DIALOG = 1
    }

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateDialog(id: Int): Dialog {
        if (id == DIALOG) {
            Log.i(LOG_TAG, "Create")
            val adb = AlertDialog.Builder(this)
            adb.setTitle("Title")
            adb.setMessage("Message")
            adb.setPositiveButton("OK", null)
            dialog = adb.create()
            dialog.setOnShowListener { Log.i(LOG_TAG, "Show") }
            dialog.setOnCancelListener { Log.i(LOG_TAG, "Cancel") }
            dialog.setOnDismissListener { Log.i(LOG_TAG, "Dismiss") }
            return dialog
        }
        return super.onCreateDialog(id)
    }

    fun method1() {
        dialog.cancel()
    }
    fun method2() {

    }

    fun onclick(v: View) {
        showDialog(DIALOG)
        val h = Handler()
        h.postDelayed(Runnable { method1() }, 2000)
        h.postDelayed(Runnable { method2() }, 4000)
    }
}