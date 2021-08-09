package com.example.p0102activitylistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

//class MainActivity : AppCompatActivity(), View.OnClickListener {
class MainActivity : AppCompatActivity() {


    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

//        btnOk.setOnClickListener(this)
//        btnCancel.setOnClickListener(this)

    }

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btnOk -> tvOut.text = "Нажата кнопка OK"
//            R.id.btnCancel -> tvOut.text = "Нажата кнопка Cancel"
//        }
//    }

    fun onClickStart(v: View?) {
        when (v?.id) {
            R.id.btnOk -> tvOut.text = "Нажата кнопка OKK"
            R.id.btnCancel -> tvOut.text = "Нажата кнопка CCancel"
        }
    }
}