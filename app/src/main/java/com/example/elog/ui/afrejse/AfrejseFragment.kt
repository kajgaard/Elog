package com.example.elog.ui.afrejse

//import androidx.lifecycle.ViewModelProvider.get
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.elog.ui.afrejse.AfrejseViewModel
import androidx.lifecycle.ViewModelProvider
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.elog.R
import com.example.elog.databinding.FragmentAfrejseBinding
import kotlinx.android.synthetic.main.afrejse_afrejseoplysninger.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val afrejsehavne = resources.getStringArray(R.array.afrejsehavne)

        // access the spinner

        if(afrejseoplysninger_dropdown!= null){
            val adapter = activity?.let {
                ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_spinner_item,
                    afrejsehavne
                )
            }
            afrejseoplysninger_dropdown.adapter=adapter
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}