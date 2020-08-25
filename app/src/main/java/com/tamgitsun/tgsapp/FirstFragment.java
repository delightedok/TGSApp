package com.tamgitsun.tgsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.tamgitsun.tgsapp.dataengines.SharedPreferencesEngine;
import com.tamgitsun.tgsapp.utils.TimeUtils;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        view.findViewById(R.id.button_no_yellow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lastSavedDate = SharedPreferencesEngine.getStringData(
                        FirstFragment.this.getContext(), null,
                        "no_yellow_last_saved_date", "1970-01-01");
                String curDate = TimeUtils.getCurDate();
                if (lastSavedDate.equals(curDate)) {
                    Toast.makeText(FirstFragment.this.getContext(),
                            R.string.main_first_toast_no_yellow_already_saved,
                            Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferencesEngine.savedData(
                            FirstFragment.this.getContext(), null, "no_yellow_times",
                            SharedPreferencesEngine.getIntData(
                                    FirstFragment.this.getContext(), null,
                                    "no_yellow_times", 0) + 1);
                    SharedPreferencesEngine.savedData(
                            FirstFragment.this.getContext(), null,
                            "no_yellow_last_saved_date", curDate);
                    Toast.makeText(FirstFragment.this.getContext(),
                            R.string.main_first_toast_no_yellow_saved_success,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}