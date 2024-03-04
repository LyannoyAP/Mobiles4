package com.example.mobiles4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RightFragment extends Fragment {

    private RecyclerView recyclerView;
    public RightFragment() {
        super(R.layout.fragment_right);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(new Item(1));
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                getContext(),
                list
        );
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()
                .getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}