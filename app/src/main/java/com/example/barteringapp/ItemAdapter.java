package com.example.barteringapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.FarmViewHolder> {
    private List<FarmItem> farmItemList;
    //private FirebaseFirestore db;

    public ItemAdapter(List<FarmItem> farmItemList) {
        this.farmItemList = farmItemList;
        // this.db = FirebaseFirestore.getInstance(); // Initialize Firestore instance
    }

    @NonNull
    @Override
    public FarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_item_format, parent, false);
        return new FarmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmViewHolder holder, int position) {
        FarmItem currentItem = farmItemList.get(position);
        holder.fullNameTextView.setText(String.format("Full Name: %s", currentItem.getFullName()));
        holder.categoryTextView.setText(String.format("Category: %s", currentItem.getCategory()));
        holder.facilityNameTextView.setText(String.format("Facility Name: %s", currentItem.getFacilityName()));
        holder.locationTextView.setText(String.format("Location: %s", currentItem.getLocation()));

        holder.recordInfoButton.setOnClickListener(v -> {
            // logItemInformation(currentItem); // Record item information on button click
            //Intent intent = new Intent(this, Home.class);
        });
    }

    @Override
    public int getItemCount() {
        return farmItemList.size();
    }

    public void setFilteredList(List<FarmItem> filteredList) {
        this.farmItemList = filteredList;
        notifyDataSetChanged();
    }

    /*private void logItemInformation(FarmItem item) {
        // Save item information to Firestore
        db.collection("items").add(item)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "Item information recorded successfully"))
                .addOnFailureListener(e -> Log.e(TAG, "Failed to record item information", e));
    }*/

    public static class FarmViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryTextView;
        public TextView facilityNameTextView;
        public TextView fullNameTextView;
        public TextView locationTextView;
        public Button recordInfoButton; // Button reference

        public FarmViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.textViewCategory);
            facilityNameTextView = itemView.findViewById(R.id.textViewFacilityName);
            fullNameTextView = itemView.findViewById(R.id.textViewFullName_RV);
            locationTextView = itemView.findViewById(R.id.textViewLocation);
            recordInfoButton = itemView.findViewById(R.id.buttonRecordInfo); // Initialize button
        }
    }
}
