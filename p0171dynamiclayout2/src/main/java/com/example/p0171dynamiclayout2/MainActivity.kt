package com.example.p0171dynamiclayout2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var llMain: LinearLayout
    lateinit var rgGravity: RadioGroup
    lateinit var etName: EditText
    lateinit var btnCreate: Button
    lateinit var btnClear: Button
    var wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llMain = findViewById(R.id.llMain)
        rgGravity = findViewById(R.id.rgGravity)
        etName = findViewById(R.id.etName)

        btnCreate = findViewById(R.id.btnCreate)
        btnCreate.setOnClickListener(this)

        btnClear = findViewById(R.id.btnClear)
        btnClear.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCreate ->  {
                val lParam = LinearLayout.LayoutParams(wrapContent, wrapContent)
                var btnGravity = Gravity.LEFT
                when (rgGravity.checkedRadioButtonId) {
                    R.id.rbLeft -> btnGravity = Gravity.LEFT
                    R.id.rbCenter -> btnGravity = Gravity.CENTER_HORIZONTAL
                    R.id.rbRight -> btnGravity = Gravity.RIGHT
                }
                lParam.gravity = btnGravity

                val btnNew = Button(this)
                btnNew.setText(etName.text.toString())
                llMain.addView(btnNew, lParam)
            }
            R.id.btnClear -> {
                llMain.removeAllViews()
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}