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
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.st_ilya.databasestudentsmireaproject.R;
import com.st_ilya.databasestudentsmireaproject.viewmodel.RegisterViewModel;

public class RegisterFragment extends Fragment {

    private EditText emailAddressLoginEdit;
    private EditText nameEdit;
    private EditText surnameEdit;
    private EditText middleNameEdit;
    private EditText dateOfBirthEdit;
    private EditText groupNumberEdit;
    private EditText facultyEdit;
    private EditText passwordEdit;

    private Button registerButton;

    private RegisterViewModel registerViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        registerViewModel.getUserMutableLiveData().observe(this, firebaseUser -> {
            if (firebaseUser != null) {
                Navigation.findNavController(getView()).navigate(R.id.action_registerFragment_to_loginRegisterFragment);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        emailAddressLoginEdit = view.findViewById(R.id.editTextTextEmailAddress);
        nameEdit = view.findViewById(R.id.nameTextEditText);
        surnameEdit = view.findViewById(R.id.surnameTextEditText);
        middleNameEdit = view.findViewById(R.id.middleNameTextEditText);
        dateOfBirthEdit = view.findViewById(R.id.dateOfBirthTextEditText);
        groupNumberEdit = view.findViewById(R.id.groupNumberTextEditText);
        facultyEdit = view.findViewById(R.id.facultyTextEditText);
        passwordEdit = view.findViewById(R.id.passwordTextEditText);

        registerButton = view.findViewById(R.id.buttonRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddressLoginEdit.getText().toString();
                String name = nameEdit.getText().toString();
                String surname = surnameEdit.getText().toString();
                String middle = middleNameEdit.getText().toString();
                String date = dateOfBirthEdit.getText().toString();
                String group = groupNumberEdit.getText().toString();
                String faculty = facultyEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if (email.length() > 0 && password.length() > 0) {
                    registerViewModel.register(email, name, surname, middle, date, group, faculty, password);
                    Navigation.findNavController(getView()).navigate(R.id.loginRegisterFragment);
                } else {
                    Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
