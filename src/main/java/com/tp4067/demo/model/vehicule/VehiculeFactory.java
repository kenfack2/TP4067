package com.tp4067.demo.model.vehicule;

public interface VehiculeFactory {
    Vehicule createVehicule(String marque, String modele,  float prix, int Nombre,String imagepath, int capacite);
}
