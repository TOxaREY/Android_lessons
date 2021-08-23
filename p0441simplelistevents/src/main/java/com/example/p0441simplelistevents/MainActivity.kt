package com.example.p0441simplelistevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.AdapterView

import android.widget.AdapterView.OnItemClickListener




class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    lateinit var lvMain: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvMain = findViewById(R.id.lvMain)
        val adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_1)
        lvMain.adapter = adapter

        lvMain.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Log.i(LOG_TAG, "itemClick: position = " + position + ", id = " + id)
            }

        lvMain.onItemSelectedListener =
            AdapterView.OnItemSelectedListener {
                fun onItemSelected(
                    parent: AdapterView<*>?, view: View?,
                    position: Int, id: Long
                ) {
                    Log.i(LOG_TAG, "itemSelect: position = " + position + ", id = " + id)
                }

                fun onNothingSelected(parent: AdapterView<*>?) {
                    Log.i(LOG_TAG, "itemSelect: nothing")
                }
            }

    }
}