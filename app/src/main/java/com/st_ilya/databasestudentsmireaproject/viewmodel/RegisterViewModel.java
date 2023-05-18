package com.st_ilya.databasestudentsmireaproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.st_ilya.databasestudentsmireaproject.model.AppRepository;

public class RegisterViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private MutableLiveData<FirebaseUser> userMutableLiveData;

    public RegisterViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
        userMutableLiveData = appRepository.getUserMutableLiveData();
    }

    public void register(String email, String name, String surname, String middleName, String dateOdBirth, String groupNumber, String faculty, String password) {
        appRepository.register(email, name, surname, middleName, dateOdBirth, groupNumber, faculty, password);
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }

}
