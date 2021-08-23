package com.example.p0491simpleadaptercustom1

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    companion object {
        const val ATTRIBUTE_NAME_TEXT = "text"
        const val ATTRIBUTE_NAME_VALUE = "value"
        const val ATTRIBUTE_NAME_IMAGE = "image"
        const val positive = android.R.drawable.arrow_up_float
        const val negative = android.R.drawable.arrow_down_float
    }
    lateinit var lvSimple: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values = intArrayOf(8, 4, -3, 2, -5, 0 , 3, -6, 1, -1)
        val data = ArrayList<Map<String, Object>>(values.count())
        var m: MutableMap<String, Object>
        var img = 0
        for (i in 0..values.count() - 1) {
            m = HashMap<String, Object>()
            m.put(ATTRIBUTE_NAME_TEXT, ("Day " + (i + 1)) as Object)
            m.put(ATTRIBUTE_NAME_VALUE, values[i] as Object)
            if (values[i] == 0) {
                img = 0
            } else {
                img = if (values[i] > 0) positive else negative
            }
            m.put(ATTRIBUTE_NAME_IMAGE, img as Object)
            data.add(m)
        }

        val from = arrayOf(ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_VALUE, ATTRIBUTE_NAME_IMAGE)
        val to = intArrayOf(R.id.tvText, R.id.tvValue, R.id.ivImg)

        val sAdapter = MySimpleAdapter(this, data, R.layout.item, from, to)
        lvSimple = findViewById(R.id.lvSimple)
        lvSimple.adapter = sAdapter
    }

    class MySimpleAdapter(
        context: Context?,
        data: ArrayList<Map<String, Object>>,
        resource: Int,
        from: Array<out String>?,
        to: IntArray?
    ) : SimpleAdapter(context, data, resource, from, to) {

        override fun setViewText(v: TextView?, text: String?) {
            super.setViewText(v, text)
            if (v?.id == R.id.tvValue) {
                val i = text?.toInt()
                if (i != null) {
                    if (i < 0) {
                        v.setTextColor((Color.RED))
                    } else {
                        if (i > 0) {
                            v.setTextColor(Color.GREEN)
                        }
                    }
                }
            }
        }

        override fun setViewImage(v: ImageView?, value: Int) {
            super.setViewImage(v, value)
            if (value == negative) {
                v?.setBackgroundColor(Color.RED)
            } else {
                if (value == positive) {
                    v?.setBackgroundColor(Color.GREEN)
                }
            }
        }
    }
}