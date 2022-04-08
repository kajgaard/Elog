package com.example.elog.ui.landing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LandingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LandingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Landing fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}