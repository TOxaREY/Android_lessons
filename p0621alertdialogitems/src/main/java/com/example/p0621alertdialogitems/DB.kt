package com.example.p0621alertdialogitems

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB {
    companion object {
        const val DB_NAME = "mydb"
        const val DB_VERSION = 1
        const val DB_TABLE = "mytab"
        const val COLUMN_ID = "_id"
        const val COLUMN_TXT = "txt"
        const val DB_CREATE = "create table " + DB_TABLE + "(" + COLUMN_ID + " integer primary key, " + COLUMN_TXT + " text" + ");"
    }
    lateinit var mCtx: Context
    lateinit var mDBHelper: DBHelper
    lateinit var mDB: SQLiteDatabase
    fun DB(ctx: Context) {
        mCtx = ctx
    }
    fun open() {
        mDBHelper = DBHelper(mCtx, DB_NAME, null, DB_VERSION)
        mDB = mDBHelper.writableDatabase
    }

    fun close() {
        if (mDBHelper != null) {
            mDBHelper.close()
        }
    }

    fun getAllData(): Cursor {
        return mDB.query(DB_TABLE, null, null, null, null, null, null)
    }

    fun changeRec(id: Int, txt: String) {
        val cv = ContentValues()
        cv.put(COLUMN_TXT, txt)
        mDB.update(DB_TABLE, cv, COLUMN_ID + " = " + id, null)
    }

    class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int):
        SQLiteOpenHelper(context, name, factory, version) {

        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL(DB_CREATE)
            val cv = ContentValues()
            for (i in 1..4) {
                cv.put(COLUMN_ID, i)
                cv.put(COLUMN_TXT, "sometext " + i)
                db?.insert(DB_TABLE, null, cv)
            }
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
    }

}