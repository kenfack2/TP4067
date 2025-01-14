package com.tp4067.demo.model.vehicule;

import org.springframework.stereotype.Component;

@Component
public class ElectriqueVehiculeFactory implements VehiculeFactory {
    @Override
    public Vehicule createVehicule(String marque, String modele, String description, float prix, int Nombre, int capaciteBatterie) {
        return new VehiculeElectrique(marque, modele,description,prix,Nombre,capaciteBatterie); // Capacité batterie par défaut
    }
}