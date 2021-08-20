package com.example.p0431simplelistchoice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    lateinit var lvMain: ListView
    lateinit var names: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvMain = findViewById(R.id.lvMain)
        lvMain.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        val adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice)
        lvMain.adapter = adapter

        val btnChecked = findViewById<Button>(R.id.btnChecked)
        btnChecked.setOnClickListener(this)

        names = resources.getStringArray(R.array.names)
    }

    override fun onClick(arg0: View?) {
        Log.i(LOG_TAG, "checked: ")
        val sbArray = lvMain.checkedItemPositions
        for (i in 0..sbArray.size() - 1) {
            val key = sbArray.keyAt(i)
            if (sbArray.get(key)) {
                Log.i(LOG_TAG, names[key])
            }
        }
    }
}