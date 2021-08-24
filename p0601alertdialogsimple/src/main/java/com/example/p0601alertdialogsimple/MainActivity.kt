package com.example.p0601alertdialogsimple

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.DialogInterface
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        const val DIALOG_EXIT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onclick(v: View) {
        showDialog(DIALOG_EXIT)
    }

    override fun onCreateDialog(id: Int): Dialog {
        if (id == DIALOG_EXIT) {
            val adb = AlertDialog.Builder(this)
            adb.setTitle(R.string.exit)
            adb.setMessage(R.string.save_data)
            adb.setIcon(android.R.drawable.ic_dialog_info)
            adb.setPositiveButton(R.string.yes, myClickListener)
            adb.setNegativeButton(R.string.no, myClickListener)
            adb.setNeutralButton(R.string.cancel, myClickListener)
            return adb.create()
        }
        return super.onCreateDialog(id)
    }

    var myClickListener: DialogInterface.OnClickListener = object : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {
            when (which) {
                Dialog.BUTTON_POSITIVE -> {
                    saveData()
                    finish()
                }
                Dialog.BUTTON_NEGATIVE -> finish()
                Dialog.BUTTON_NEUTRAL -> {
                }
            }
        }
    }

    override fun onBackPressed() {
        showDialog(DIALOG_EXIT)
    }

    fun saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
    }
}