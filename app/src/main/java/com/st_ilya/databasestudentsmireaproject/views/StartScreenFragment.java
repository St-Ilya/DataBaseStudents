package com.st_ilya.databasestudentsmireaproject.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseUser;
import com.st_ilya.databasestudentsmireaproject.R;
import com.st_ilya.databasestudentsmireaproject.viewmodel.StartScreenViewModel;

public class StartScreenFragment extends Fragment {

    private Button signInButton;
    private Button signUpButton;

    private StartScreenViewModel startScreenViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startScreenViewModel = new ViewModelProvider(this).get(StartScreenViewModel.class);
        startScreenViewModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                Navigation.findNavController(getView()).navigate(R.id.action_startScreenFragment_to_loginRegisterFragment);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_screen, container, false);

        signInButton = view.findViewById(R.id.signInButton);
        signUpButton = view.findViewById(R.id.signUpButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.loginRegisterFragment);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.registerFragment);
            }
        });

        return view;
    }


}
