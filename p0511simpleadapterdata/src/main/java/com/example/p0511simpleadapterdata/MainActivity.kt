package com.example.p0511simpleadapterdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.jar.Attributes
import android.widget.AdapterView.AdapterContextMenuInfo




class MainActivity : AppCompatActivity() {

    companion object {
        const val ATTRIBUTE_NAME_TEXT = "text"
        const val ATTRIBUTE_NAME_IMAGE = "image"
        const val CM_DELETE_ID = 1
    }
    lateinit var lvSimple: ListView
    lateinit var sAdapter: SimpleAdapter
    lateinit var data: ArrayList<Map<String, Any>>
    lateinit var m: MutableMap<String, Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data =ArrayList<Map<String, Any>>()
        for (i in 1..4) {
            m = HashMap<String, Any>()
            m.put(ATTRIBUTE_NAME_TEXT, ("sometext " + i) as String)
            m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher_foreground)
            data.add(m)
        }
        val from = arrayOf(ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE)
        val to = intArrayOf(R.id.tvText, R.id.ivImg)
        sAdapter = SimpleAdapter(this, data, R.layout.item, from, to)
        lvSimple = findViewById(R.id.lvSimple)
        lvSimple.adapter = sAdapter
        registerForContextMenu(lvSimple)
    }
    fun onButtonClick(v: View) {
        m = HashMap<String, Any>()
        m.put(ATTRIBUTE_NAME_TEXT, ("sometext " + (data.count() + 1)) as String)
        m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher_foreground)
        data.add(m)
        sAdapter.notifyDataSetChanged()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(0, CM_DELETE_ID, 0, "Удалить запись")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == CM_DELETE_ID) {
            val acmi = item.menuInfo as AdapterContextMenuInfo
            data.removeAt(acmi.position)
            sAdapter.notifyDataSetChanged()
            return true
        }
        return super.onContextItemSelected(item)
    }
}