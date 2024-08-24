package com.example.thriv31.ui.stories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StoriesViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public StoriesViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
