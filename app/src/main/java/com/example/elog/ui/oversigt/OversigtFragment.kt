package com.example.elog.ui.oversigt

//import androidx.lifecycle.ViewModelProvider.get
//import android.R


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrdeveloper.treeview.TreeNode
import com.amrdeveloper.treeview.TreeViewAdapter
import com.amrdeveloper.treeview.TreeViewHolderFactory
import com.example.elog.R
import com.example.elog.databinding.FragmentOversigtBinding
import kotlinx.android.synthetic.main.fragment_oversigt.*


//import com.example.elog.R.*


class OversigtFragment : Fragment() {
    private var binding: FragmentOversigtBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val oversigtViewModel = ViewModelProvider(this).get(OversigtViewModel::class.java)
        binding = FragmentOversigtBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        //val textView = binding!!.textOversigt
        //oversigtViewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }




        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.isNestedScrollingEnabled = false

        val factory =
            TreeViewHolderFactory { v: View, layout: Int -> CustomViewHolder(v) }

        val treeViewAdapter = TreeViewAdapter(factory)
        recycler_view.adapter = treeViewAdapter


        val javaDirectory = TreeNode("Java", R.layout.list_item_file)
        javaDirectory.addChild(TreeNode("FileJava1.java", R.layout.list_item_file))
        javaDirectory.addChild(TreeNode("FileJava2.java", R.layout.list_item_file))
        javaDirectory.addChild(TreeNode("FileJava3.java", R.layout.list_item_file))

        val fileRoots: MutableList<TreeNode> = ArrayList()
        fileRoots.add(javaDirectory)

        treeViewAdapter.updateTreeNodes(fileRoots)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}