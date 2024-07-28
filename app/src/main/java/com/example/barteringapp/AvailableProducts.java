package com.example.barteringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableProducts extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter farmAdapter;
    private List<FarmItem> farmItemList;
    private Spinner spinnerCategory;
    private Button buttonGoBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_products);

        // Initialize the button and set up the click listener
        buttonGoBack = findViewById(R.id.buttonGoBack);
        buttonGoBack.setOnClickListener(v -> {
            Intent intent = new Intent(AvailableProducts.this, Home.class);
            startActivity(intent);
        });

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //**DELETE THIS INITIALIZED LIST WHEN SETTING UP FIREBASE**
        // Initialize the list of farm items
        farmItemList = new ArrayList<>();
        farmItemList.add(new FarmItem("Dairy", "Sunny Farms", "John Doe", "California"));
        farmItemList.add(new FarmItem("Poultry", "Feather Fields", "Jane Smith", "Texas"));
        farmItemList.add(new FarmItem("Dairy", "Green Pastures", "Mike Johnson", "New York"));
        farmItemList.add(new FarmItem("Vegetable", "Veggie Valley", "Sara Brown", "Florida"));

        // Set up the adapter for the RecyclerView
        farmAdapter = new ItemAdapter(farmItemList);
        recyclerView.setAdapter(farmAdapter);

        // Initialize the Spinner
        spinnerCategory = findViewById(R.id.spinner_category);
        setupSpinner();
    }

    private void setupSpinner() {
        // Initialise the spinner with a preset list of items
        List<String> categories = new ArrayList<>();
        categories.add("All");
        categories.add("Crops and vegetables");
        categories.add("Farming Tools");
        categories.add("Vegetable");

        // Create an ArrayAdapter for the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        // Set up the listener for spinner item selection
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = (String) parent.getItemAtPosition(position);
                filterRecyclerView(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void filterRecyclerView(String category) {
        List<FarmItem> filteredList;

        if (category.equals("All")) {
            filteredList = new ArrayList<>(farmItemList);
        } else {
            filteredList = farmItemList.stream()
                    .filter(item -> item.getCategory().equals(category))
                    .collect(Collectors.toList());
        }

        // Update the adapter with the filtered list
        farmAdapter.setFilteredList(filteredList);
    }
}
