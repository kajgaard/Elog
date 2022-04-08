package com.example.elog.ui.fangst;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FangstViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FangstViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Fangst fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}