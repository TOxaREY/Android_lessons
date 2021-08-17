package com.example.p0141menuadv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.TextView

lateinit var tv: TextView
lateinit var chb: CheckBox

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView)
        chb = findViewById(R.id.chbExtMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu ?: return false
//        menu.add(0, 1, 0, "add")
//        menu.add(0, 2, 0, "edit")
//        menu.add(0, 3, 3, "delete")
//        menu.add(1, 4, 1, "copy")
//        menu.add(1, 5, 2, "paste")
//        menu.add(1, 6, 4, "exit")
        menuInflater.inflate(R.menu.mymenu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu ?: return false
//        menu.setGroupVisible(1, chb.isChecked)
        menu.setGroupVisible(R.id.group1, chb.isChecked)

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sb = StringBuilder()
        sb.append("Item menu")
        sb.append("\r\n groupId: " + item.groupId)
        sb.append("\r\n itemId: " + item.itemId)
        sb.append("\r\n order: " + item.order)
        sb.append("\r\n title: " + item.title)
        tv.text = sb.toString()

        return super.onOptionsItemSelected(item)
    }
}