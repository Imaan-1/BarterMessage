package com.example.barteringapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<Contact> contacts;
    private OnContactClickListener onContactClickListener;

    public ContactAdapter(List<Contact> contacts, OnContactClickListener onContactClickListener) {
        this.contacts = contacts;
        this.onContactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.nameTextView.setText(contact.getName());
        holder.emailTextView.setText(contact.getEmail());
        holder.itemView.setOnClickListener(v -> onContactClickListener.onContactClick(contact));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, emailTextView;

        ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName1);
            emailTextView = itemView.findViewById(R.id.textViewEmail1);
        }
    }

    interface OnContactClickListener {
        void onContactClick(Contact contact);
    }
}
