package com.example.elog.ui.oversigt;

import android.view.View;

import androidx.annotation.NonNull;

import com.amrdeveloper.treeview.TreeNode;
import com.amrdeveloper.treeview.TreeViewHolder;

public class CustomViewHolder extends TreeViewHolder {

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindTreeNode(TreeNode node) {
        super.bindTreeNode(node);
        // Here you can bind your node and check if it selected or not
    }
}
