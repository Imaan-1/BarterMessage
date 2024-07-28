package com.example.barteringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Barter extends Fragment {

    private Button buttonViewItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_barter, container, false);

        // Initialize the button
        buttonViewItems = view.findViewById(R.id.buttonViewItems);

        // Set click listener for the button
        buttonViewItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use getActivity() to get context since this is a fragment
                Intent intent = new Intent(getActivity(), AvailableProducts.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
