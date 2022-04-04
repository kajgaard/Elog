package com.example.elog.ui.melding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeldingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MeldingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Melding fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}