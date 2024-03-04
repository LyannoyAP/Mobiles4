package com.example.mobiles4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    private Button b_left, b_right;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b_left = view.findViewById(R.id.b_left);
        b_right = view.findViewById(R.id.b_right);
        b_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_main, LeftFragment.class, null)
                        .commit();
            }
        });
        b_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_main, RightFragment.class, null)
                        .commit();
            }
        });
    }
}