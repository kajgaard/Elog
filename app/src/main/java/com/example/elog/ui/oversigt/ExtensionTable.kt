package com.example.elog.ui.oversigt

import com.amrdeveloper.treeview.TreeViewHolder
import android.widget.TextView
import com.example.elog.R
import com.example.elog.ui.oversigt.ExtensionTable

object ExtensionTable {
    fun getExtensionIcon(extension: String?): Int {
        return when (extension) {
            ".rod" -> R.drawable.rod
            ".gul" -> R.drawable.gul
            ".gron" -> R.drawable.groen
            else -> R.drawable.ic_file
        }
    }
}