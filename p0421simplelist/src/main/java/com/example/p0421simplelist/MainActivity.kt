package com.example.p0421simplelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val names = arrayOf("Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMain = findViewById<ListView>(R.id.lvMain)
        val adapter = ArrayAdapter<String>(this, R.layout.my_list_item, names)

        lvMain.adapter = adapter
    }
}