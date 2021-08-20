package com.example.p0411layoutinflaterlist

import android.app.ActionBar
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val name = arrayOf("Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь")
        val position = arrayOf("Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник")
        val salary = arrayOf(13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000)
        val colors = IntArray(2)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colors[0] = Color.parseColor("#559966CC")
        colors[1] = Color.parseColor("#55336699")

        val linLayout = findViewById<LinearLayout>(R.id.linLayout)
        val ltInflater = layoutInflater

        for (i in 0..name.count() - 1) {
            Log.i("myLogs", "i = " + i)
            val item = ltInflater.inflate(R.layout.item, linLayout, false)
            val tvName = item.findViewById<TextView>(R.id.tvName)
            tvName.text = name[i]
            val tvPosition = item.findViewById<TextView>(R.id.tvPosition)
            tvPosition.text = "Должность: " + position[i]
            val tvSalary = item.findViewById<TextView>(R.id.tvSalary)
            tvSalary.text = "Оклад: " + salary[i].toString()
            item.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            item.setBackgroundColor(colors[i % 2])
            linLayout.addView(item)
        }
    }
}