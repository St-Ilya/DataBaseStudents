package com.st_ilya.databasestudentsmireaproject.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseUser;
import com.st_ilya.databasestudentsmireaproject.R;
import com.st_ilya.databasestudentsmireaproject.viewmodel.RegisterViewModel;

public class RegisterFragment extends Fragment {

    private EditText emailAddressLogin;
    private EditText name;
    private EditText surname;
    private EditText middleName;
    private EditText dateOfBirth;
    private EditText groupNumber;
    private EditText faculty;
    private EditText password;

    private Button registerButton;

    private RegisterViewModel registerViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        registerViewModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Navigation.findNavController(getView()).navigate(R.id.action_registerFragment_to_loginRegisterFragment);
                }
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        emailAddressLogin = view.findViewById(R.id.editTextTextEmailAddress);
        name = view.findViewById(R.id.nameTextEditText);
        surname = view.findViewById(R.id.surnameTextEditText);
        middleName = view.findViewById(R.id.middleNameTextEditText);
        dateOfBirth = view.findViewById(R.id.dateOfBirthTextEditText);
        groupNumber = view.findViewById(R.id.groupNumberTextEditText);
        faculty = view.findViewById(R.id.facultyTextEditText);
        password = view.findViewById(R.id.passwordTextEditText);

        registerButton = view.findViewById(R.id.buttonRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddressLogin.getText().toString();
                String name = emailAddressLogin.getText().toString();
                String surname = emailAddressLogin.getText().toString();
                String middle = emailAddressLogin.getText().toString();
                String date = emailAddressLogin.getText().toString();
                String faculty = emailAddressLogin.getText().toString();
                String password = emailAddressLogin.getText().toString();

                if (email.length() > 0 && password.length() > 0) {
                    registerViewModel.register(email, password);
                } else {
                    Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return view;
    }
}
