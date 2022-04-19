package com.example.elog.ui.oversigt

import android.view.View
import android.widget.ImageView
import com.amrdeveloper.treeview.TreeViewHolder
import android.widget.TextView
import com.amrdeveloper.treeview.TreeNode
import com.example.elog.R
import com.example.elog.ui.oversigt.ExtensionTable

class CustomViewHolder(itemView: View) : TreeViewHolder(itemView) {
    private var fileName: TextView? = null
    private var fileStateIcon: ImageView? = null
    private var fileTypeIcon: ImageView? = null
    private fun initViews() {
        fileName = itemView.findViewById(R.id.file_name)
        fileStateIcon = itemView.findViewById(R.id.file_state_icon)
        fileTypeIcon = itemView.findViewById(R.id.file_type_icon)
    }

    override fun bindTreeNode(node: TreeNode) {
        super.bindTreeNode(node)
        val fileNameStr = node.value.toString()
        fileName!!.text = fileNameStr
        val dotIndex = fileNameStr.indexOf('.')
        if (dotIndex == -1) {
            val extension = fileNameStr.substring(dotIndex)
            val extensionIcon = ExtensionTable.getExtensionIcon(extension)
            fileTypeIcon!!.setImageResource(extensionIcon)
        } else {
            val extension = fileNameStr.substring(dotIndex)
            val extensionIcon = ExtensionTable.getExtensionIcon(extension)
            fileTypeIcon!!.setImageResource(extensionIcon)
        }
        if (node.children.isEmpty()) {
            fileStateIcon!!.visibility = View.INVISIBLE
        } else {
            fileStateIcon!!.visibility = View.VISIBLE
            val stateIcon =
                if (node.isExpanded) R.drawable.ic_arrow_down else R.drawable.ic_arrow_right
            fileStateIcon!!.setImageResource(stateIcon)
        }
    }

    init {
        initViews()
    }
}