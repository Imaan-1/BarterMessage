package com.example.barteringapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {
    private FloatingActionButton buttonAccount, buttonMessages, buttonBarter;
    private TextView textViewAccount, textViewMessages, textViewBarter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonAccount = findViewById(R.id.floatingActionButtonAccount);
        buttonMessages = findViewById(R.id.floatingActionButtonMessages);
        buttonBarter = findViewById(R.id.floatingActionButtonBarter);

        textViewAccount = findViewById(R.id.textViewAccount);
        textViewMessages = findViewById(R.id.textViewMessages);
        textViewBarter = findViewById(R.id.textViewBarter);

        buttonAccount.setOnClickListener(view -> {
            loadFragment(new Account());
            highlightTextView(textViewAccount);
        });

        buttonMessages.setOnClickListener(view -> {
            loadFragment(new Messages());
            highlightTextView(textViewMessages);
        });

        buttonBarter.setOnClickListener(view -> {
            loadFragment(new Barter());
            highlightTextView(textViewBarter);
        });



        // Load default fragment
        if (savedInstanceState == null) {
            loadFragment(new Messages());
            highlightTextView(textViewMessages);
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void highlightTextView(TextView textView) {
        textViewAccount.setTextColor(getResources().getColor(R.color.white));
        textViewAccount.setTypeface(null, Typeface.NORMAL);

        textViewMessages.setTextColor(getResources().getColor(R.color.white));
        textViewMessages.setTypeface(null, Typeface.NORMAL);

        textViewBarter.setTextColor(getResources().getColor(R.color.white));
        textViewBarter.setTypeface(null, Typeface.NORMAL);

        // Highlight the selected text view
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setTypeface(null, Typeface.BOLD);
    }
}
