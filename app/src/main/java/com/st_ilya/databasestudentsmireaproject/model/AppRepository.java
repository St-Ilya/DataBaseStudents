package com.st_ilya.databasestudentsmireaproject.model;

import android.app.Application;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.st_ilya.databasestudentsmireaproject.views.RegisterFragment;

import java.util.HashMap;
import java.util.Map;

public class AppRepository {

    public static final String TAG = "TAG";
    private Application application;
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userMutableLiveData;
    private MutableLiveData<Boolean> loggedOutMutableLiveData;
    private FirebaseFirestore fStore;
    private String userID;

    private String emailAddressLogin;
    private String name;
    private String surname;
    private String middleName;
    private String dateOfBirth;
    private String groupNumber;
    private String faculty;
    private String passwordd;

    public AppRepository(Application application) {
        this.application = application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.userMutableLiveData = new MutableLiveData<>();
        this.loggedOutMutableLiveData = new MutableLiveData<>();

        if (firebaseAuth.getCurrentUser() != null) {
            userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOutMutableLiveData.postValue(false);
        }
    }

    public void register(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            userID = firebaseAuth.getCurrentUser().getUid();
                            fStore = FirebaseFirestore.getInstance();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("email", emailAddressLogin);
                            user.put("name", name);
                            user.put("surname", surname);
                            user.put("middleName", middleName);
                            user.put("dateOfBirth", dateOfBirth);
                            user.put("groupNumber", groupNumber);
                            user.put("faculty", faculty);
                            user.put("password", passwordd);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                                }
                            });

                            userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            Toast.makeText(application, "Register Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void login(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(application.getMainExecutor(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            Toast.makeText(application, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void logOut() {
        firebaseAuth.signOut();
        loggedOutMutableLiveData.postValue(true);
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutMutableLiveData() {
        return loggedOutMutableLiveData;
    }
}
