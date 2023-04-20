package com.st_ilya.databasestudentsmireaproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.st_ilya.databasestudentsmireaproject.model.AppRepository;

public class LoggedInViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private MutableLiveData<FirebaseUser> userMutableLiveData;
    private MutableLiveData<Boolean> loggedOutMutableLiveData;

    public LoggedInViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
        userMutableLiveData = appRepository.getUserMutableLiveData();
        loggedOutMutableLiveData = appRepository.getLoggedOutMutableLiveData();
    }

    public void logOut() {
        appRepository.logOut();
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutMutableLiveData() {
        return loggedOutMutableLiveData;
    }
}
