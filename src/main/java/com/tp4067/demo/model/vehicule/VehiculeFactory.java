package com.tp4067.demo.model.vehicule;

public interface VehiculeFactory {
    Vehicule createVehicule(String marque, String modele, String description, float prix, int Nombre, int capacite);
}
