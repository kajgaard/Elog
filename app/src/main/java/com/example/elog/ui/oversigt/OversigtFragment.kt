package com.example.elog.ui.oversigt

//import androidx.lifecycle.ViewModelProvider.get
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.example.elog.ui.oversigt.OversigtViewModel
import androidx.lifecycle.ViewModelProvider
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.elog.databinding.FragmentOversigtBinding
import com.example.elog.ui.melding.MeldingViewModel
import com.example.elog.ui.landing.LandingViewModel
import com.example.elog.ui.fangst.FangstViewModel

class OversigtFragment : Fragment() {
    private var binding: FragmentOversigtBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val oversigtViewModel = ViewModelProvider(this).get(OversigtViewModel::class.java)
        binding = FragmentOversigtBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textOversigt
        oversigtViewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}