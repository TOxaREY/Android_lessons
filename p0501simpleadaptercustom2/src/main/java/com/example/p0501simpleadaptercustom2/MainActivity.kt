package com.example.p0501simpleadaptercustom2

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import android.R.attr.data
import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.ProgressBar





class MainActivity : AppCompatActivity() {

    companion object {
        const val ATTRIBUTE_NAME_TEXT = "text"
        const val ATTRIBUTE_NAME_PB = "pb"
        const val ATTRIBUTE_NAME_LL = "ll"
    }
    lateinit var lvSimple: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val load = intArrayOf(41, 48, 22, 35, 30, 67, 51, 88)
        val data = ArrayList<Map<String, Any>>(load.count())
        var m: MutableMap<String, Any>
        for (i in 0..load.count() - 1) {
            m = HashMap<String, Any>()
            m.put(ATTRIBUTE_NAME_TEXT, ("Day " + (i+1) + ". Load: " + load[i] + "%") as String)
            m.put(ATTRIBUTE_NAME_PB, load[i] as Int)
            m.put(ATTRIBUTE_NAME_LL, load[i] as Int)
            data.add(m)
        }
        val from = arrayOf(ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_PB, ATTRIBUTE_NAME_LL)
        val to = intArrayOf(R.id.tvLoad, R.id.pbLoad, R.id.llLoad)
        val sAdapter = SimpleAdapter(this, data, R.layout.item, from, to)
        sAdapter.setViewBinder(MyViewBinder())

        lvSimple = findViewById(R.id.lvSimple)
        lvSimple.adapter = sAdapter
    }

    class MyViewBinder: SimpleAdapter.ViewBinder {

        @SuppressLint("ResourceAsColor")
        override fun setViewValue(view: View?, data: Any?, textRepresentation: String?): Boolean {
            var i = 0
            when (view?.id) {
                R.id.llLoad -> {
                    i = data as Int
                    if (i < 40) {
                        view?.setBackgroundColor(Color.GREEN)
                    } else {
                        if (i < 70) {
                            view?.setBackgroundColor(Color.YELLOW)
                        } else {
                            view?.setBackgroundColor(Color.RED)
                        }
                    }
                    return true
                }
                R.id.pbLoad -> {
                    i = data as Int
                    (view as ProgressBar).progress = i
                    return true
                }
            }
            return false
        }
    }
}