package com.example.barteringapp;

import static com.example.barteringapp.R.id.textViewRatingValue;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Account extends Fragment {

    private Button buttonSignOut;
    private ProgressBar progressBarRating;
    private TextView textViewRatingValue;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_account, container, false);
        buttonSignOut = view.findViewById(R.id.buttonSignOut);
        buttonSignOut.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SignIn.class);
            startActivity(intent);
        });
        textViewRatingValue = view.findViewById(R.id.textViewRatingValue);
        setQualityRating(0.0);

        return view;


    }

    private void setQualityRating (double rating) {
        textViewRatingValue.setText(String.format("%.1f/5", rating));
    }



}
