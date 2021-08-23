package com.example.p0581timepickerdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.app.TimePickerDialog
import android.widget.TimePicker

import android.app.TimePickerDialog.OnTimeSetListener





class MainActivity : AppCompatActivity() {

    companion object {
        const val DIALOG_TIME = 1
        var myHour = 14
        var myMinute = 35
    }
    lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTime = findViewById(R.id.tvTime)
    }

    fun onclick(view: View) {
        showDialog(DIALOG_TIME)
    }

    override fun onCreateDialog(id: Int): Dialog {
        if (id == DIALOG_TIME) {
            val tpd = TimePickerDialog(this, myCallBack, myHour, myMinute, true)
            return tpd
        }
        return super.onCreateDialog(id)
    }
    var myCallBack =
        OnTimeSetListener { view, hourOfDay, minute ->
            myHour = hourOfDay
            myMinute = minute
            tvTime.text = "Time is $myHour hours $myMinute minutes"
        }
}