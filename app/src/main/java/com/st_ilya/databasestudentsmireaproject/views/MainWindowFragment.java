package com.st_ilya.databasestudentsmireaproject.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.st_ilya.databasestudentsmireaproject.R;
import com.st_ilya.databasestudentsmireaproject.viewmodel.MainWindowViewModel;

public class MainWindowFragment extends Fragment {

    private Button openSettingButton;

    private MainWindowViewModel mainWindowViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);

        openSettingButton = view.findViewById(R.id.openSettingButton);
        openSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toDo toolBar
            }
        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
