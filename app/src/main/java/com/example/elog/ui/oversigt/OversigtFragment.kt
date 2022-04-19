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


        val afrejseMelding = TreeNode("Afrejse: 14-03-2022 12:00, STRANDBY (NORDJYLLAND) (DKSTD).gron", R.layout.list_item_root)
        afrejseMelding.addChild(TreeNode("Kvitteret: 14-03-2022 12:50.gron", R.layout.list_item_child))
        afrejseMelding.addChild(TreeNode("Havnekenningsnummer: FN123.gron", R.layout.list_item_child))
        afrejseMelding.addChild(TreeNode("Fartøjsnavn: Ulla-Britta.gron", R.layout.list_item_child))
        afrejseMelding.addChild(TreeNode("Radiokaldesignal: ABCDEFG.gron", R.layout.list_item_child))
        afrejseMelding.addChild(TreeNode("Fartøjsfører: Maria K.gron", R.layout.list_item_child))
        afrejseMelding.addChild(TreeNode("Fartøjsførers adresse: Gærtorvet 3, 1799 København.gron", R.layout.list_item_child))
        afrejseMelding.addChild(TreeNode("Kvitteret: 14-03-2022 12:50.gron", R.layout.list_item_child))

        val afrejseRedskab = TreeNode("Redskaber ombord:.gron", R.layout.list_item_child)
        afrejseRedskab.addChild(TreeNode("TBB Bomtrawl, Størrelse 10mm, Dimension: 2, Antal 1.gron", R.layout.list_item_child))

        afrejseMelding.addChild(afrejseRedskab)

        val danskMelding = TreeNode("Melding: Nyt lossetidspunkt.gul", R.layout.list_item_root)
        danskMelding.addChild(TreeNode("Type: Nyt lossetidspunkt.gul", R.layout.list_item_child))
        danskMelding.addChild(TreeNode("Fiskeri: Industri.gul", R.layout.list_item_child))
        danskMelding.addChild(TreeNode("Dato:16-03-2022 10:00.gul", R.layout.list_item_child))
        danskMelding.addChild(TreeNode("Sendes til: DNK.gul", R.layout.list_item_child))




        val fangstMelding = TreeNode("Fangst: 14:00.rod", R.layout.list_item_root)
        fangstMelding.addChild(TreeNode("Kladde: Nej.rod", R.layout.list_item_child))
        fangstMelding.addChild(TreeNode("Udsætningsdato og -tid 14-03-2022 13:00.rod", R.layout.list_item_child))

        val passiveFangstredskaber = TreeNode("Antal passive fangstredskaber: 1.rod", R.layout.list_item_child)
        passiveFangstredskaber.addChild(TreeNode("HHV Hummertejner, Størrelse: 15mm, Dimension: 1, Antal: 12.rod",R.layout.list_item_child))

        fangstMelding.addChild(passiveFangstredskaber)
        fangstMelding.addChild(TreeNode("Udsætning br/lg 72°N 43,6’/14°V 33,9’.rod", R.layout.list_item_child))
        fangstMelding.addChild(TreeNode("Statistisk rektangel 74D5.rod", R.layout.list_item_child))
        fangstMelding.addChild(TreeNode("Farvand 14A (NORDØST FOR GRØNLAND).rod", R.layout.list_item_child))
        fangstMelding.addChild(TreeNode("Økonomisk zone: GRL (GRØNLAND).rod", R.layout.list_item_child))




        val fileRoots: MutableList<TreeNode> = ArrayList()
        fileRoots.add(afrejseMelding)
        fileRoots.add(danskMelding)
        fileRoots.add(fangstMelding)

        treeViewAdapter.updateTreeNodes(fileRoots)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}