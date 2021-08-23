package com.example.p0481simpleadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    companion object {
        const val ATTRIBUTE_NAME_TEXT = "text"
        const val ATTRIBUTE_NAME_CHECKED = "checked"
        const val ATTRIBUTE_NAME_IMAGE = "image"
    }
    lateinit var lvSimple: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texts = arrayOf("sometext 1", "sometext 2", "sometext 3",
            "sometext 4", "sometext 5")
        val checked = arrayOf(true, false, false, true, false)
        val img = R.drawable.ic_launcher_background
        val data = ArrayList<Map<String, Object>>(texts.count())
        var m: MutableMap<String, Object>
        for (i in 0..texts.count() - 1) {
            m = HashMap<String, Object>()
            m.put(ATTRIBUTE_NAME_TEXT, texts[i] as Object)
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i] as Object)
            m.put(ATTRIBUTE_NAME_IMAGE, img as Object)
            data.add(m)
        }

        val from = arrayOf(ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED, ATTRIBUTE_NAME_IMAGE, ATTRIBUTE_NAME_TEXT)
        val to = intArrayOf(R.id.tvText, R.id.cbChecked, R.id.ivImg, R.id.cbChecked)

        val adapter = SimpleAdapter(this, data, R.layout.item, from, to)

        lvSimple = findViewById(R.id.lvSimple)
        lvSimple.adapter = adapter
    }
}