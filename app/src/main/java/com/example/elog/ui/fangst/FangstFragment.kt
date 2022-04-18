package com.example.elog.ui.fangst

//import androidx.lifecycle.ViewModelProvider.get
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.elog.R
import com.example.elog.databinding.FragmentFangstBinding
import kotlinx.android.synthetic.main.fangst_fangstoplysninger.*
import kotlinx.android.synthetic.main.fangst_redskaber.*
import kotlinx.android.synthetic.main.fangst_standardbesked.*
import kotlinx.android.synthetic.main.fangst_tagesop.*
import kotlinx.android.synthetic.main.fangst_udsaetning.*
import kotlinx.android.synthetic.main.fragment_fangst.*
import kotlinx.android.synthetic.main.tilfoj_row.*
import kotlinx.android.synthetic.main.tilfoj_row.view.*


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

        val farvandListe = resources.getStringArray(R.array.farvandskoder)
        val adapterFarvande = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, farvandListe)
        farvandAuto.setAdapter(adapterFarvande)
        //TODO evt lave farvandsnavne om til koder

        val okoListe = resources.getStringArray(R.array.okozoner)
        val adapterOkozoner = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, okoListe)
        okozoneAuto.setAdapter(adapterOkozoner)
        //TODO evt lave økozonenavne om til koder

        val naturaListe = resources.getStringArray(R.array.natura2000)
        val adapterNatura = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, naturaListe)
        naturaAuto.setAdapter(adapterNatura)

        standardbesked_help.setOnClickListener{
            Toast.makeText(requireContext(), "Forlægning til anden havn, vagttjeneste ved boreplatforme, transportrejser til fangstområder hvor sejlads tager mere end 24 timer etc.", Toast.LENGTH_LONG).show();
        }

        fangst_tagetop_help.setOnClickListener{
            Toast.makeText(requireContext(), "Tidspunkt og position for hvor trækket afsluttes", Toast.LENGTH_LONG).show();
        }

        fangst_fangstoplys_help.setOnClickListener{
            Toast.makeText(requireContext(), "Position hvor den største andel fisk skønnes at være fanget", Toast.LENGTH_LONG).show();
        }

        val longitudeList = resources.getStringArray(R.array.longitude)
        val adapterLon = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, longitudeList)
        udPosLonAuto.setAdapter(adapterLon)
        indPosLonAuto.setAdapter(adapterLon)
        fangstPosLonAuto.setAdapter(adapterLon)

        val lattitudeList = resources.getStringArray(R.array.lattitude)
        val adapterLat = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, lattitudeList)
        udPosLatAuto.setAdapter(adapterLat)
        indPosLatAuto.setAdapter(adapterLat)
        fangstPosLatAuto.setAdapter(adapterLat)



        tilfojLinjeBtn.setOnClickListener{
            Log.i("BUT", "add new btn clicked")
            tilfojLinjeBtn.text = "Tilføj række"
            fangstdetaljer_overskrifter.isVisible = true
            addView()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    fun addView(){
        val fangstLinjeView = layoutInflater.inflate(R.layout.tilfoj_row,null, false)

        fangstScrollview.post {fangstScrollview.fullScroll(ScrollView.FOCUS_DOWN)}

        val artListe = resources.getStringArray(R.array.arter)
        val adapterArter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, artListe)
        fangstLinjeView.artAuto.setAdapter(adapterArter)

        val enhedsListe = resources.getStringArray(R.array.enheder)
        val adapterEnheder = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item, enhedsListe)
        fangstLinjeView.enhedAuto.setAdapter(adapterEnheder)

        fangstLinjeView.sletRowIV.setOnClickListener {
            print("Remove btn clicked")
            Log.i("BUT", "remove btn clicked")
            removeView(fangstLinjeView)
        }

        fangst_layout_list.addView(fangstLinjeView)
    }

    fun removeView(view: View){
        fangst_layout_list.removeView(view)
        Log.i("BUT", "removed")
        if(fangst_layout_list.size == 0){
            fangstdetaljer_overskrifter.visibility = View.GONE
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}