package com.example.elog.ui.melding

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
import com.example.elog.databinding.FragmentMeldingBinding
import com.example.elog.ui.melding.MeldingViewModel
import com.example.elog.ui.landing.LandingViewModel
import com.example.elog.ui.fangst.FangstViewModel

class MeldingFragment : Fragment() {
    private var binding: FragmentMeldingBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val meldingViewModel = ViewModelProvider(this).get(MeldingViewModel::class.java)
        binding = FragmentMeldingBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textMelding
        meldingViewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}