package com.example.barteringapp;

public class FarmItem {
    private String category;
    private String facilityName;
    private String fullName;
    private String location, email;


    private String description;

    public FarmItem(String category, String facilityName, String fullName, String location) {
        this.category = category;
        this.facilityName = facilityName;
        this.fullName = fullName;
        this.location = location;
        this.description = description;
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail(){
        return email; }

}

