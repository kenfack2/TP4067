package com.tp4067.demo.model.vehicule;
import org.springframework.stereotype.Component;


@Component
public class EssenceVehiculeFactory implements VehiculeFactory {

    @Override
    public Vehicule createVehicule(String marque, String modele, String description, float prix, int Nombre, int capaciteReservoir) {
        return new VehiculeEssence(marque, modele,description,prix,Nombre,capaciteReservoir); // Capacité réservoir par défaut
    }
}

