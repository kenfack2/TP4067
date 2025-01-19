package com.tp4067.demo.model.users;

import jakarta.persistence.Entity;

@Entity
public class PersonneOrdinaire extends Client {
    private String dateNaissance;

    // Getters et Setters
    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
