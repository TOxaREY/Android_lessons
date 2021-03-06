package com.example.p0551headerfooter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.HeaderViewListAdapter
import android.widget.ListView
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    val data = arrayOf("one", "two", "three", "four", "five")
    lateinit var lvMain: ListView
    lateinit var adapter: ArrayAdapter<String>
    lateinit var header1: View
    lateinit var header2: View
    lateinit var footer1: View
    lateinit var footer2: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvMain = findViewById(R.id.lvMain)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        header1 = createHeader("header 1")
        header2 = createHeader("header 2")
        footer1 = createFooter("footer 1")
        footer2 = createFooter("footer 2")

        fillList()
    }

    fun fillList() {
        lvMain.addHeaderView(header1)
        lvMain.addHeaderView(header2, "some text for header 2", false)
        lvMain.addFooterView(footer1)
        lvMain.addFooterView(footer2, "some text for footer 2", false)
        lvMain.adapter = adapter
    }

    fun onclick(v: View) {
        var obj: Any
        val hvlAdapter = lvMain.adapter as HeaderViewListAdapter
        obj = hvlAdapter.getItem(1)
        Log.i(LOG_TAG, "hvlAdapter.getItem(1) = " + obj.toString())
        obj = hvlAdapter.getItem(4)
        Log.i(LOG_TAG, "hvlAdapter.getItem(4) = " + obj.toString())
        val alAdapter = hvlAdapter.wrappedAdapter
        obj = alAdapter.getItem(1)
        Log.i(LOG_TAG, "alAdapter.getItem(1) = " + obj.toString())
        obj = alAdapter.getItem(4)
        Log.i(LOG_TAG, "alAdapter.getItem(4) = " + obj.toString())
    }

    fun createHeader(text: String): View {
        val v = layoutInflater.inflate(R.layout.header, null)
        v.findViewById<TextView>(R.id.tvText).text = text
        return v
    }

    fun createFooter(text: String): View {
        val v = layoutInflater.inflate(R.layout.footer, null)
        v.findViewById<TextView>(R.id.tvText).text = text
        return v
    }
}