package com.example.p0361sqlitequary

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    val name = arrayOf("Китай", "США", "Бразилия", "Россия", "Япония",
        "Германия", "Египет", "Италия", "Франция", "Канада")
    val region = arrayOf("Азия", "Америка", "Америка", "Европа", "Азия",
        "Европа", "Африка", "Европа", "Европа", "Америка")
    val people = arrayOf(1400, 311, 195, 142, 128, 82, 80, 60, 66, 35)
    lateinit var btnAll: Button
    lateinit var btnFunc: Button
    lateinit var btnPeople: Button
    lateinit var btnSort: Button
    lateinit var btnGroup: Button
    lateinit var btnHaving: Button
    lateinit var etFunc: EditText
    lateinit var etPeople: EditText
    lateinit var etRegionPeople: EditText
    lateinit var rgSort: RadioGroup
    internal lateinit var dbHelper: DBHelper
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAll = findViewById(R.id.btnAll)
        btnFunc = findViewById(R.id.btnFunc)
        btnPeople = findViewById(R.id.btnPeople)
        btnSort = findViewById(R.id.btnSort)
        btnGroup = findViewById(R.id.btnGroup)
        btnHaving = findViewById(R.id.btnHaving)
        btnAll.setOnClickListener(this)
        btnFunc.setOnClickListener(this)
        btnPeople.setOnClickListener(this)
        btnSort.setOnClickListener(this)
        btnGroup.setOnClickListener(this)
        btnHaving.setOnClickListener(this)
        etFunc = findViewById(R.id.etFunc)
        etPeople = findViewById(R.id.etPeople)
        etRegionPeople = findViewById(R.id.etRegionPeople)
        rgSort = findViewById(R.id.rgSort)
        dbHelper = DBHelper(this)
        db = dbHelper.getWritableDatabase()
        val c = db.query("mytable", null, null, null, null, null, null)
        if (c.count == 0) {
            val cv = ContentValues()
            for (i in 0..9) {
                cv.put("name", name[i])
                cv.put("people", people[i])
                cv.put("region", region[i])
                Log.i(LOG_TAG, "id = " + db.insert("mytable", null, cv))
            }
        }
        c.close()
        dbHelper.close()
        onClick(btnAll)
    }

    override fun onClick(v: View?) {
        db = dbHelper.getWritableDatabase()
        val sFunc = etFunc.text.toString()
        val sPeople = etPeople.text.toString()
        val sRegionPeople = etRegionPeople.text.toString()

        var columns: Array<String>? = null
        var selection: String? = null
        var selectionArgs: Array<String>? = null
        var groupBy: String? = null
        var having: String? = null
        var orderBy: String? = null
        var c: Cursor? = null

        when(v?.id) {
            R.id.btnAll -> {
                Log.i(LOG_TAG, "--- Все записи ---")
                c = db.query("mytable", null, null, null, null, null, null)
            }
            R.id.btnFunc -> {
                Log.i(LOG_TAG, "--- Функция " + sFunc + " ---")
                columns = arrayOf(sFunc)
                c = db.query("mytable", columns, null, null, null, null, null)
            }
            R.id.btnPeople -> {
                Log.i(LOG_TAG, "--- Население больше " + sPeople + " ---")
                selection = "people > ?"
                selectionArgs = arrayOf(sPeople)
                c = db.query("mytable", columns, selection, selectionArgs, null, null, null)
            }
            R.id.btnGroup -> {
                Log.i(LOG_TAG, "--- Население по региону ---")
                columns = arrayOf("region", "sum(people) as people")
                groupBy = "region"
                c = db.query("mytable", columns, null, null, groupBy, null, null)
            }
            R.id.btnHaving -> {
                Log.i(LOG_TAG, "--- Регионы с населением больше  " + sRegionPeople + " ---")
                columns = arrayOf("region", "sum(people) as people")
                groupBy = "region"
                having = "sum(people) > " + sRegionPeople
                c = db.query("mytable", columns, null, null, groupBy, having, null)
            }
            R.id.btnSort -> {
                when(rgSort.checkedRadioButtonId) {
                    R.id.rName -> {
                        Log.i(LOG_TAG, "--- Сортировка по наименованию ---")
                        orderBy = "name"
                    }
                    R.id.rPeople -> {
                        Log.i(LOG_TAG, "--- Сортировка по населению ---")
                        orderBy = "people"
                    }
                    R.id.rRegion -> {
                        Log.i(LOG_TAG, "--- Сортировка по региону ---")
                        orderBy = "region"
                    }
                }
                c = db.query("mytable", null, null, null, null, null, orderBy)
            }
        }
        if (c != null) {
            if (c.moveToFirst()) {
                var str: String
                do {
                    str = ""
                    for (cn in c.getColumnNames()) {
                        str = str + cn + " = " + c.getString(c.getColumnIndex(cn)) + "; "
                    }
                    Log.i(LOG_TAG, str)
                } while (c.moveToNext())
            }
            c.close()
        } else {
            Log.i(LOG_TAG, "Cursor is null")
        }
        dbHelper.close()
    }

    internal class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {

        override fun onCreate(db: SQLiteDatabase) {
            Log.i(LOG_TAG, "--- onCreate database ---")
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "people integer,"
                    + "region text" + ");"
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        }
    }
}