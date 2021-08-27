package com.example.p0751files

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import java.io.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "myLogs"
        const val FILENAME = "file"
        const val DIR_SD = "MyFiles"
        const val FILENAME_SD = "fileSD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onclick(v: View) {
        when (v.id) {
            R.id.btnWrite -> writeFile()
            R.id.btnRead -> readFile()
            R.id.btnWriteSD -> writeFileSD()
            R.id.btnReadSD -> readFileSD()
        }
    }
    fun writeFile() {
        try {
            val bw = BufferedWriter(OutputStreamWriter(openFileOutput(FILENAME, MODE_PRIVATE)))
            bw.write("Содержимое файла")
            bw.close()
            Log.i(LOG_TAG, "Файл записан")
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun readFile() {
        try {
            val br = BufferedReader(InputStreamReader(openFileInput(FILENAME)))
            var str = ""
            while (br.readLine().also { str = it } != null) {
                Log.i(LOG_TAG, str)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    fun writeFileSD() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.i(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState())
            return
        }
        var sdPath = Environment.getExternalStorageDirectory()
        sdPath = File(sdPath.absolutePath + "/" + DIR_SD)
        sdPath.mkdirs()
        val sdFile = File(sdPath, FILENAME_SD)
        try {
            val bw = BufferedWriter(FileWriter(sdFile))
            bw.write("Содержимое файла на SD")
            bw.close()
            Log.i(LOG_TAG, "Файл записан на SD: " + sdFile.absolutePath)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readFileSD() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.i(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState())
            return
        }
        var sdPath = Environment.getExternalStorageDirectory()
        sdPath = File(sdPath.absolutePath + "/" + DIR_SD)
        val sdFile = File(sdPath, FILENAME_SD)
        try {
            val br = BufferedReader(FileReader(sdFile))
            var str = ""
            while (br.readLine().also { str = it } != null) {
                Log.i(LOG_TAG, str)
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}