package com.example.barteringapp;

public class UserHelper {
    String firstName, surname, email, password, farmingFacility;

    public UserHelper (String firstName, String surname, String email, String password, String farmingFacility) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.farmingFacility = farmingFacility;
    }

    public String getEmail() {
        return email;
    }

    public String getFarmingFacility() {
        return farmingFacility;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFarmingFacility(String farmingFacility) {
        this.farmingFacility = farmingFacility;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
