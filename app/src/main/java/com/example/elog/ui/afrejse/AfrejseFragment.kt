package com.example.elog.ui.afrejse

//import androidx.lifecycle.ViewModelProvider.get
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.createNavigateOnClickListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.elog.MainActivity
import com.example.elog.R
import com.example.elog.databinding.FragmentAfrejseBinding
import com.example.elog.ui.oversigt.OversigtFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.afrejse_afrejseoplysninger.*
import kotlinx.android.synthetic.main.afrejse_afrejseoplysninger.view.*
import kotlinx.android.synthetic.main.afrejse_fartojsidentifikation.*
import kotlinx.android.synthetic.main.afrejse_makkerfiskeri.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_afrejse.*

class AfrejseFragment : Fragment() {
    private var binding: FragmentAfrejseBinding? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val afrejseViewModel = ViewModelProvider(this).get(AfrejseViewModel::class.java)
        binding = FragmentAfrejseBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        //val textView = binding!!.textAfrejse
       // afrejseViewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }


        return root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val afrejsehavne = resources.getStringArray(R.array.afrejsehavne)

        val adapterHavne = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,afrejsehavne)
        afrejseoplysninger_autoCompleteTextView.setAdapter(adapterHavne)


        val forerliste = resources.getStringArray(R.array.fartojsforer)
        val adapterSkipper = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, forerliste)
        fartoj_autoCompleteTextView.setAdapter(adapterSkipper)

        val makkerliste = resources.getStringArray(R.array.makkerliste)
        val adapterMakker = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, makkerliste)
        makkerfiskeri_autoCompleteTextView.setAdapter(adapterMakker)



        afrejseoplysninger_help.setOnClickListener{
            Toast.makeText(requireContext(), "Forudfyldt med den havn du sidst er ankommet til, hvis det ikke er korrekt kan du v??lge fra listen", Toast.LENGTH_LONG).show();
        }


// set checkbox checked change listener
        makkerCB.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                makkerfiskeri_autoCompleteTextView.setBackgroundResource(R.drawable.edittext_border)
                makkerfiskeri_textInputLayout.isEnabled = true
                makker_tv.setTextColor(resources.getColor(R.color.moerkblaa))

            }else{
                makkerfiskeri_autoCompleteTextView.setBackgroundResource(R.drawable.edittext_inactive_border)
                makkerfiskeri_textInputLayout.isEnabled = false
                makker_tv.setTextColor(resources.getColor(R.color.inaktiv_tekst_grey))
            }
        }


        afrejseAnullerBtn.setOnClickListener{
            findNavController().navigate(R.id.nav_oversigt)
        }


        afrejseSendBtn.setOnClickListener{
               findNavController().navigate(R.id.nav_oversigt)

       }

        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}