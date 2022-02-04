package com.detection.diseases.maize.ui.Crops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.detection.diseases.maize.R;

public class CropsFragment extends Fragment {

    private CropsViewModel cropsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cropsViewModel =
                new ViewModelProvider(this).get(CropsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crops, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        cropsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}