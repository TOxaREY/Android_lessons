package com.example.p0591datepickerdialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val DIALOG_DATE = 1
        var myYear = 2011
        var myMonth = 2
        var myDay = 3
    }
    lateinit var tvDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvDate = findViewById(R.id.tvDate)
    }
    fun onclick(view: View) {
        showDialog(DIALOG_DATE)
    }
    override fun onCreateDialog(id: Int): Dialog {
        if (id == DIALOG_DATE) {
            val tpd = DatePickerDialog(this, myCallBack, myYear, myMonth, myDay)
            return tpd
        }
        return super.onCreateDialog(id)
    }
    var myCallBack =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myYear = year
            myMonth = monthOfYear
            myDay = dayOfMonth
            tvDate.text = "Today is $myDay / $myMonth / $myDay"
        }
}