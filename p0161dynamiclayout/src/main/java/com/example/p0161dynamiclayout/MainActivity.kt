package com.example.p0161dynamiclayout

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linLayuot = LinearLayout(this)
        linLayuot.orientation = LinearLayout.VERTICAL
        val linLayoutParam = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val lpView = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val tv = TextView(this)
        tv.setText("TextView")
        tv.layoutParams = lpView
        linLayuot.addView(tv)

        val btn = Button(this)
        btn.setText("Button")
        linLayuot.addView(btn, lpView)

        val leftMarginParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        leftMarginParams.leftMargin = 50

        val btn1 = Button(this)
        btn1.setText("Button1")
        linLayuot.addView(btn1, leftMarginParams)

        val rightGravityParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        rightGravityParams.gravity = Gravity.RIGHT

        val btn2 = Button(this)
        btn2.setText("Button2")
        linLayuot.addView(btn2, rightGravityParams)


        setContentView(linLayuot, linLayoutParam)
    }
}