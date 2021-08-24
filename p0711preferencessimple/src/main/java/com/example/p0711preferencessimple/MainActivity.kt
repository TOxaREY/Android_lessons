package com.example.p0711preferencessimple

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvInfo: TextView
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tvInfo)
        sp = PreferenceManager.getDefaultSharedPreferences(this)
//        sp.edit().clear().commit()
    }

    override fun onResume() {
        val notif = sp.getBoolean("notif", false)
        val address = sp.getString("address", "")
        val text = ("Notifications are " + if (notif) "enabled, address = $address" else "disabled")
        tvInfo.text = text
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mi = menu?.add(0, 1, 0, "Preferences")
        mi?.intent = Intent(this, PrefActivity::class.java)
        return super.onCreateOptionsMenu(menu)
    }
}