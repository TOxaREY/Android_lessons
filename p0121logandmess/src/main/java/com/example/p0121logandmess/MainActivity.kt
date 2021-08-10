package com.example.p0121logandmess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button

    private val tag: String = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(tag, "Найдем View-элементы")
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        Log.i(tag, "Присваиваем обработчик кнопкам")
        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

        override fun onClick(v: View?) {
            Log.i(tag, "по id определяем кнопку, вызвавшую этот обработчик")
        when (v?.id) {
            R.id.btnOk -> {
                tvOut.text = "Нажата кнопка OK"
                Log.i(tag, "кнопка OK")
                Toast.makeText(this, "Нажата кнопка OK", Toast.LENGTH_LONG).show()
            }
            R.id.btnCancel -> { 
                tvOut.text = "Нажата кнопка Cancel"
                Log.i(tag, "кнопка Cancel")
                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show()
            }
        }
    }
}