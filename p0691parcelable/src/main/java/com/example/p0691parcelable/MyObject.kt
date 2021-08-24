package com.example.p0691parcelable

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import kotlin.properties.Delegates

class MyObject() : Parcelable {

    companion object {
        const val LOG_TAG = "myLogs"
    }

    lateinit var s: String
    var i by Delegates.notNull<Int>()

    private constructor(_s: String, _i: Int) : this() {
        Log.i(LOG_TAG, "MyObject(Parcel parcel)")
        s = _s
        i = _i
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        Log.i(LOG_TAG, "writeToParcel")
        parcel.writeString(s)
        parcel.writeInt(i)
    }


    val CREATOR: Parcelable.Creator<MyObject> = object : Parcelable.Creator<MyObject?> {
        override fun createFromParcel(`in`: Parcel): MyObject? {
            Log.d(LOG_TAG, "createFromParcel")
            return MyObject(`in`)
        }

        override fun newArray(size: Int): Array<MyObject?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this() {
        s = parcel.readString()
        i = parcel.readInt()
    }

    // конструктор, считывающий данные из Parcel
    private fun MyObject(parcel: Parcel) {
        Log.d(LOG_TAG, "MyObject(Parcel parcel)")
        s = parcel.readString()!!
        i = parcel.readInt()
    }

    companion object CREATOR : Parcelable.Creator<MyObject> {
        override fun createFromParcel(parcel: Parcel): MyObject {
            return MyObject(parcel)
        }

        override fun newArray(size: Int): Array<MyObject?> {
            return arrayOfNulls(size)
        }
    }
}
