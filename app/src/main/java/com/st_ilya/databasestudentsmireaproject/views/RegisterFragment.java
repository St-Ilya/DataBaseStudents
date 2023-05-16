package com.st_ilya.databasestudentsmireaproject.views;

import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.st_ilya.databasestudentsmireaproject.viewmodel.RegisterViewModel;

public class RegisterFragment extends Fragment {

    private EditText emailAddress;
    private EditText name;
    private EditText surname;
    private EditText middleName;
    private EditText dateOfBirth;
    private EditText groupNumber;
    private EditText faculty;
    private EditText password;

    private Button registerButton;

    private RegisterViewModel registerViewModel;


}
