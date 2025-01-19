package com.tp4067.demo.model.vehicule;

import org.springframework.stereotype.Component;

@Component
public class ElectriqueVehiculeFactory implements VehiculeFactory {
    @Override
    public Vehicule createVehicule(String marque, String modele,  float prix, int Nombre,String imagepath, int capaciteBatterie) {
        return new VehiculeElectrique(marque, modele,prix,Nombre,imagepath,capaciteBatterie); // Capacité batterie par défaut
    }
}