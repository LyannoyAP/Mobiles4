package com.example.mobiles4;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LeftFragment extends Fragment {
    private ListView listView;
    public LeftFragment() {
        super(R.layout.fragment_left);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        List<Item> list = new ArrayList<>();
        Bundle bundle = getArguments();
        if ((bundle != null) && bundle.containsKey("qCount")) {
            for (int i = 0; i < bundle.getInt("qCount"); i++) {
                list.add(new Item(0));
            }
        }
        else {
            for (int i = 0; i < 200; i++) {
                list.add(new Item(0));
            }
        }
        ListViewAdapter adapter = new ListViewAdapter(
                getContext(),
                R.layout.list_view_adapter,
                list
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Item clicked: " + position, Toast.LENGTH_SHORT)
                        .show();
                Log.i(TAG, "Item clicked: " + position);
            }
        });
    }
}