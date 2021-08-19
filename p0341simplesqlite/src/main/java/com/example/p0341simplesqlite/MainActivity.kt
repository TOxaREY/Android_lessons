package com.example.p0341simplesqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.prefs.PreferencesFactory

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val LOG_TAG = "myLogsSQL"
    }
    lateinit var btnAdd: Button
    lateinit var btnRead: Button
    lateinit var btnClear: Button
    lateinit var btnUpd: Button
    lateinit var btnDel: Button
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etID: EditText
    internal lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btnAdd)
        btnRead = findViewById(R.id.btnRead)
        btnClear = findViewById(R.id.btnClear)
        btnUpd = findViewById(R.id.btnUpd)
        btnDel = findViewById(R.id.btnDel)
        btnAdd.setOnClickListener(this)
        btnRead.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        btnUpd.setOnClickListener(this)
        btnDel.setOnClickListener(this)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etID = findViewById(R.id.etID)
        dbHelper = DBHelper(this)
    }

    override fun onClick(v: View?) {
        val cv = ContentValues()
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val id = etID.text.toString()
        val db = dbHelper.getWritableDatabase()

        when(v?.id) {
            R.id.btnAdd -> {
                Log.i(LOG_TAG, "---Insert in mytable: ---")
                cv.put("name", name)
                cv.put("email", email)
                val rowID = db.insert("mytable", null, cv)
                Log.i(LOG_TAG, "row inserted, ID = " + rowID)
            }
            R.id.btnRead -> {
                Log.i(LOG_TAG, "---Rows in mytable: ---")
                val c = db.query("mytable", null, null, null, null, null, null)
                if (c.moveToFirst()) {
                    val idColIndex = c.getColumnIndex("id")
                    val nameColIndex = c.getColumnIndex("name")
                    val emailColIndex = c.getColumnIndex("email")
                    do {
                        Log.i(LOG_TAG, "ID = " + c.getInt(idColIndex) +
                                ", name = " + c.getString(nameColIndex) +
                                ", email = " + c.getString(emailColIndex))
                    } while (c.moveToNext())
                } else {
                    Log.i(LOG_TAG, "0 rows")
                }
                c.close()
            }
            R.id.btnClear -> {
                Log.i(LOG_TAG, "--- Clear mytable: ---")
                val clearCount = db.delete("mytable", null, null)
                Log.i(LOG_TAG, "delete rows count = " + clearCount)
            }
            R.id.btnUpd -> {
                if (!id.equals("", true)) {
                    Log.i(LOG_TAG, "---Update mytable: ---")
                    cv.put("name", name)
                    cv.put("email", email)
                    val updCount = db.update("mytable", cv, "id = ?", arrayOf(id))
                    Log.i(LOG_TAG, "update rows count = " + updCount)
                }
            }
            R.id.btnDel -> {
                if (!id.equals("", true)) {
                    Log.i(LOG_TAG, "---Delete mytable: ---")
                    val delCount = db.delete("mytable", "id = " + id, null)
                    Log.i(LOG_TAG, "delete rows count = " + delCount)
                }
            }
        }
        Log.i(LOG_TAG, "---CLOSE DB ---")
        dbHelper.close()
    }


    internal class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {

        override fun onCreate(db: SQLiteDatabase) {
            Log.i(LOG_TAG, "--- onCreate database ---")
            db.execSQL("create table mytable ("
                        + "id integer primary key autoincrement,"
                        + "name text,"
                        + "email text" + ");"
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        }
    }
}