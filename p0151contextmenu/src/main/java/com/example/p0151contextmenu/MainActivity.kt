package com.example.p0151contextmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvColor: TextView
    lateinit var tvSize: TextView
    companion object {
        const val MENU_COLOR_RED = 1
        const val MENU_COLOR_GREEN = 2
        const val MENU_COLOR_BLUE = 3

        const val MENU_SIZE_22 = 4
        const val MENU_SIZE_26 = 5
        const val MENU_SIZE_30 = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvColor = findViewById(R.id.tvColor)
        tvSize = findViewById(R.id.tvSize)

        registerForContextMenu(tvColor)
        registerForContextMenu(tvSize)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when (v?.id) {
            R.id.tvColor -> {
                menu?.add(0, MENU_COLOR_RED, 0, "Red")
                menu?.add(0, MENU_COLOR_GREEN, 0, "Green")
                menu?.add(0, MENU_COLOR_BLUE, 0, "Blue")
            }
            R.id.tvSize -> {
                menu?.add(0, MENU_SIZE_22, 0, "22")
                menu?.add(0, MENU_SIZE_26, 0, "26")
                menu?.add(0, MENU_SIZE_30, 0, "30")
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_COLOR_RED -> {
                tvColor.setTextColor(Color.RED)
                tvColor.text = "Text color = red"
            }
            MENU_COLOR_GREEN -> {
                tvColor.setTextColor(Color.GREEN)
                tvColor.text = "Text color = green"
            }
            MENU_COLOR_BLUE -> {
                tvColor.setTextColor(Color.BLUE)
                tvColor.text = "Text color = blue"
            }
            MENU_SIZE_22 -> {
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22.0.toFloat())
                tvSize.text = "Text size = 22"
            }
            MENU_SIZE_26 -> {
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26.0.toFloat())
                tvSize.text = "Text size = 26"
            }
            MENU_SIZE_30 -> {
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30.0.toFloat())
                tvSize.text = "Text size = 30"
            }
        }

        return super.onContextItemSelected(item)
    }
}