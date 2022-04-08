package com.example.elog.ui.afrejse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AfrejseViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AfrejseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is afrejse fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
