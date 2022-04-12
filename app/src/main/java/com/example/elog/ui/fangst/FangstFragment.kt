package com.example.elog.ui.fangst

//import androidx.lifecycle.ViewModelProvider.get
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.elog.ui.oversigt.OversigtViewModel
import androidx.lifecycle.ViewModelProvider
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.elog.R
import com.example.elog.databinding.FragmentFangstBinding
import com.example.elog.ui.melding.MeldingViewModel
import com.example.elog.ui.landing.LandingViewModel
import com.example.elog.ui.fangst.FangstViewModel
import kotlinx.android.synthetic.main.afrejse_fartojsidentifikation.*
import kotlinx.android.synthetic.main.fangst_redskaber.*
import kotlinx.android.synthetic.main.fangst_standardbesked.*

class FangstFragment : Fragment() {
    private var binding: FragmentFangstBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fangstViewModel = ViewModelProvider(this).get(FangstViewModel::class.java)
        binding = FragmentFangstBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val redskaberliste = resources.getStringArray(R.array.redskaber)
        val adapterRedskaber = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, redskaberliste)
        redskaboplysninger_autoCompleteTextView.setAdapter(adapterRedskaber)

        val redskabsFejlListe = resources.getStringArray(R.array.redskabsFejl)
        val adapterRedskabsFejl = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, redskabsFejlListe)
        redskabfejl_autoCompleteTextView.setAdapter(adapterRedskabsFejl)

        val beskedListe = resources.getStringArray(R.array.standardbeskeder)
        val adapterBeskeder = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, beskedListe)
        beskeder_autoCompleteTextView.setAdapter(adapterBeskeder)




        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}