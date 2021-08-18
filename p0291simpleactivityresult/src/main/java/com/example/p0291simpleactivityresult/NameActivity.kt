package com.example.p0291simpleactivityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class NameActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etName: EditText
    lateinit var btnOK: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.name)

        etName = findViewById(R.id.etName)
        btnOK = findViewById(R.id.btnOK)
        btnOK.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        intent.putExtra("name", etName.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}