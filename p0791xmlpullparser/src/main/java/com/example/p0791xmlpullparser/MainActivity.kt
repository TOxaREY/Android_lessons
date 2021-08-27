package com.example.p0791xmlpullparser

import android.content.res.XmlResourceParser
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    companion object{
        const val LOG_TAG = "myLogs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tmp = ""
        try {
            val xpp = prepareXpp()
            while (xpp.eventType != XmlPullParser.END_DOCUMENT) {
                when (xpp.eventType) {
                    XmlPullParser.START_DOCUMENT -> Log.i(LOG_TAG, "START_DOCUMENT")
                    XmlPullParser.START_TAG -> {
                        Log.i(LOG_TAG, "START_TAG: name = " + xpp.name + ", depth = " + xpp.depth + ", attrCount = " + xpp.attributeCount)
                        tmp = ""
                        for (i in 0..xpp.attributeCount - 1) {
                            tmp = tmp + xpp.getAttributeName(i) + " = " + xpp.getAttributeValue(i) + ", "
                        }
                        if (!TextUtils.isEmpty(tmp)) {
                            Log.i(LOG_TAG, "Attributes: " + tmp)
                        }
                    }
                    XmlPullParser.END_TAG -> Log.i(LOG_TAG, "END_TAG: name = " + xpp.name)
                    XmlPullParser.TEXT -> Log.i(LOG_TAG, "text = " + xpp.text)
                }
                xpp.next()
            }
            Log.i(LOG_TAG, "END_DOCUMENT")
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }



    }

    fun prepareXpp(): XmlResourceParser {
        return resources.getXml(R.xml.data)
    }
}