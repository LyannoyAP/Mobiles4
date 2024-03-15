package com.example.mobiles4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    private Button b_left, b_right;
    private EditText e_qcount;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b_left = view.findViewById(R.id.b_left);
        b_right = view.findViewById(R.id.b_right);
        e_qcount = view.findViewById(R.id.e_qcount);
        b_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = e_qcount.getText().toString();
                if (str.isEmpty() || !str.matches("\\d+")) {
                    Navigation.findNavController(v).navigate(R.id.a_left);
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("qCount", Integer.parseInt(str));
                    Navigation.findNavController(v).navigate(R.id.a_left, bundle);
                }
            }
        });
        b_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = e_qcount.getText().toString();
                if (str.isEmpty() || !str.matches("\\d+")) {
                    Navigation.findNavController(v).navigate(R.id.a_right);
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("qCount", Integer.parseInt(str));
                    Navigation.findNavController(v).navigate(R.id.a_right, bundle);
                }
            }
        });
    }
}