package com.example.elog.ui.fangst

//import androidx.lifecycle.ViewModelProvider.get
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.elog.ui.oversigt.OversigtViewModel
import androidx.lifecycle.ViewModelProvider
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.elog.ui.melding.MeldingViewModel
import com.example.elog.ui.landing.LandingViewModel
import com.example.elog.ui.fangst.FangstViewModel

class FangstViewModel : ViewModel() {
    private val mText: MutableLiveData<String?>
    val text: LiveData<String?>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is Fangst fragment"
    }
}