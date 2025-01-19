package com.tp4067.demo.model.vehicule;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ELECTRIQUE")
public class VehiculeElectrique extends Vehicule {

    private int capaciteBatterie;

    public int getCapaciteBatterie() {
        return this.capaciteBatterie;
    }

    public void setCapaciteBatterie(int capaciteBatterie) {
        this.capaciteBatterie = capaciteBatterie;
    }

    public VehiculeElectrique(String marque, String modele, float prix, int Nombre, String imagepath, int capaciteBatterie) {  
        super(marque, modele, prix, Nombre,imagepath);  
        this.capaciteBatterie = capaciteBatterie;  
    }  

    public VehiculeElectrique() {}

}