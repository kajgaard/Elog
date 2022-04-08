package com.example.elog.ui.oversigt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OversigtViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public OversigtViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is oversigt fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}