package com.example.p0181dynamiclayout3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    lateinit var sbWeight: SeekBar
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var lParams1: LinearLayout.LayoutParams
    lateinit var lParams2: LinearLayout.LayoutParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sbWeight = findViewById(R.id.sbWeight)
        sbWeight.setOnSeekBarChangeListener(this)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        lParams1 = btn1.layoutParams as LinearLayout.LayoutParams
        lParams2 = btn2.layoutParams as LinearLayout.LayoutParams
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekBar ?: return
        var leftValue = progress
        var rightValue = seekBar.max - progress

        lParams1.weight = leftValue.toFloat()
        lParams2.weight = rightValue.toFloat()

        btn1.setText(leftValue.toString())
        btn2.setText(rightValue.toString())
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}