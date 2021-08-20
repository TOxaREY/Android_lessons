package com.example.p0381sqlitetransaction

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
    }
    lateinit var dbh: DBHelper
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(LOG_TAG, "--- onCreate Activity ---")
        dbh = DBHelper(this)
        myActions()
    }

    fun myActions() {
        db = dbh.writableDatabase
        delete(db, "mytable")
        db.beginTransaction()
        insert(db, "mytable", "val1")
        db.setTransactionSuccessful()
        insert(db, "mytable", "val2")
        db.endTransaction()
        insert(db, "mytable", "val3")
        read(db,"mytable")
        dbh.close()
    }

    fun insert(db: SQLiteDatabase, table: String, value: String) {
        Log.i(LOG_TAG, "Insert in table " + table + " value = " + value)
        val cv = ContentValues()
        cv.put("val", value)
        db.insert(table, null, cv)
    }

    fun read(db: SQLiteDatabase, table: String) {
        Log.i(LOG_TAG, "Read table " + table)
        val c = db.query(table, null, null, null, null, null, null)
        if (c != null) {
            Log.i(LOG_TAG, "Record count = " + c.count)
            if (c.moveToFirst()) {
                do {
                    Log.i(LOG_TAG, c.getString(c.getColumnIndex("val")))
                } while (c.moveToNext())
            }
            c.close()
        }
    }

    fun delete(db: SQLiteDatabase, table: String) {
        Log.i(LOG_TAG, "Delete all from table " + table)
        db.delete(table, null, null)
    }

    inner class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {

        override fun onCreate(db: SQLiteDatabase) {
            Log.i(LOG_TAG, "--- onCreate database ---")
            val cv = ContentValues()
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "val text"
                    + ");"
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        }
    }
}