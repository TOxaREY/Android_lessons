package com.example.p0761tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabHost = findViewById<TabHost>(android.R.id.tabhost)
        tabHost.setup()
        var tabSpec: TabHost.TabSpec
        tabSpec = tabHost.newTabSpec("tag1")
        tabSpec.setIndicator("Вкладка 1")
        tabSpec.setContent(R.id.tvTab1)
        tabHost.addTab(tabSpec)

        tabSpec = tabHost.newTabSpec("tag2")
        tabSpec.setIndicator("Вкладка 2", resources.getDrawable(R.drawable.tab_icon_selector))
        tabSpec.setContent(R.id.tvTab2)
        tabHost.addTab(tabSpec)

        tabSpec = tabHost.newTabSpec("tag3")
        val v = layoutInflater.inflate(R.layout.tab_header, null)
        tabSpec.setIndicator(v)
        tabSpec.setContent(R.id.tvTab3)
        tabHost.addTab(tabSpec)

        tabHost.setCurrentTabByTag("tag2")

        tabHost.setOnTabChangedListener(TabHost.OnTabChangeListener {
            Toast.makeText(baseContext, "tabId = " + it, Toast.LENGTH_SHORT).show()
        })
    }
}