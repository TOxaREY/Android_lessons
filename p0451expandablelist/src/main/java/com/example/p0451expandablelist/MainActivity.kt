package com.example.p0451expandablelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.SimpleExpandableListAdapter

class MainActivity : AppCompatActivity() {

    val groups = arrayOf("HTC", "Samsung", "LG")
    val phonesHTC = arrayOf("Sensation", "Desire", "Wildfire", "Hero")
    val phonesSams = arrayOf("Galaxy S II", "Galaxy Nexus", "Wave")
    val phonesLG = arrayOf("Optimus", "Optimus Link", "Optimus Black", "Optimus One")

    lateinit var groupData: ArrayList<Map<String, String>>
    lateinit var childDataItem: ArrayList<Map<String, String>>
    lateinit var childData: ArrayList<ArrayList<Map<String, String>>>
    lateinit var elvMain: ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupData = ArrayList()
        for (group in groups) {
            val m = HashMap<String, String>()
            m.put("groupName", group)
            groupData.add(m)
        }
        val groupFrom = arrayOf("groupName")
        val groupTo = IntArray(android.R.id.text1)

        childData = ArrayList()
        childDataItem = ArrayList()

        for (phone in phonesHTC) {
            val m = HashMap<String, String>()
            m.put("phoneName", phone)
            childDataItem.add(m)
        }
        childData.add(childDataItem)

        childDataItem = ArrayList()

        for (phone in phonesSams) {
            val m = HashMap<String, String>()
            m.put("phoneName", phone)
            childDataItem.add(m)
        }
        childData.add(childDataItem)

        for (phone in phonesLG) {
            val m = HashMap<String, String>()
            m.put("phoneName", phone)
            childDataItem.add(m)
        }
        childData.add(childDataItem)

        val childFrom = arrayOf("phoneName")
        val childTo = IntArray(android.R.id.text1)
        val adapter = SimpleExpandableListAdapter(
            this,
            groupData,
            android.R.layout.simple_expandable_list_item_1,
            groupFrom,
            groupTo,
            childData,
            android.R.layout.simple_list_item_1,
            childFrom,
            childTo)
        elvMain = findViewById(R.id.elvMain)
        elvMain.setAdapter(adapter)
    }
}