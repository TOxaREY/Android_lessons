package com.example.p0651alertdialogcustom

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    companion object {
        const val DIALOG = 1
    }

    var btn = 0
    lateinit var view: LinearLayout
    val sdf = SimpleDateFormat("HH:mm:ss")
    lateinit var tvCount: TextView
    lateinit var textViews: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViews = ArrayList(10)
    }

    fun onclick(v: View) {
        btn = v.id
        showDialog(DIALOG)
    }

    override fun onCreateDialog(id: Int): Dialog {
        val adb = AlertDialog.Builder(this)
        adb.setTitle("Custom dialog")
        view = layoutInflater.inflate(R.layout.dialog, null) as LinearLayout
        adb.setView(view)
        tvCount = view.findViewById(R.id.tvCount)
        return adb.create()
    }

    override fun onPrepareDialog(id: Int, dialog: Dialog?) {
        super.onPrepareDialog(id, dialog)
        if (id == DIALOG) {
            val tvTime = dialog?.window?.findViewById<TextView>(R.id.tvTime)
            tvTime?.text = sdf.format(Date(System.currentTimeMillis()))
            if (btn == R.id.btnAdd) {
                val tv = TextView(this)
                view.addView(tv, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
                tv.setText("TextView " + (textViews.count() + 1))
                textViews.add(tv)
            }
        } else {
            if (textViews.count() > 0) {
                val tv = textViews.get(textViews.count() - 1)
                view.removeView(tv)
                textViews.remove(tv)
            }
        }
        tvCount.setText("Кол-вл TextView = " + textViews.count().toString())
    }
}