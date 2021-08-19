package com.example.p0331sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.Toast
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etText: EditText
    lateinit var btnSave: Button
    lateinit var btnLoad: Button
    lateinit var sPref: SharedPreferences

    companion object {
        const val SAVED_TEXT = "saved_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etText = findViewById(R.id.etText)
        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)
        btnSave.setOnClickListener(this)
        btnLoad.setOnClickListener(this)

        loadText()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSave -> saveText()
            R.id.btnLoad -> loadText()
        }
    }
    fun saveText() {
        sPref = getPreferences(MODE_PRIVATE)
        val ed = sPref.edit()
        ed.putString(SAVED_TEXT, etText.text.toString())
        ed.commit()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }
    fun loadText() {
        sPref = getPreferences(MODE_PRIVATE)
        val savedText = sPref.getString(SAVED_TEXT, "")
        etText.setText(savedText)
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveText()
    }
}