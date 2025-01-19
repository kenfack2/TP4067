package com.tp4067.demo.model.vehicule;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("ESSENCE")
public class VehiculeEssence extends Vehicule {

    private int capaciteReservoir;

    public int getCapaciteReservoir() {
        return this.capaciteReservoir;
    }

    public void setCapaciteReservoir(int capaciteReservoir) {
        this.capaciteReservoir = capaciteReservoir;
    }

    public VehiculeEssence() {
    }

    public VehiculeEssence(String marque, String modele, float prix, int Nombre, String imagepath, int capaciteReservoir) {  
        super(marque, modele,prix, Nombre, imagepath);  
        this.capaciteReservoir = capaciteReservoir;  
    }  
    
}