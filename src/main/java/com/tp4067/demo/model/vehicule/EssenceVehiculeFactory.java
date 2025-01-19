package com.tp4067.demo.model.vehicule;
import org.springframework.stereotype.Component;


@Component
public class EssenceVehiculeFactory implements VehiculeFactory {

    @Override
    public Vehicule createVehicule(String marque, String modele, float prix, int Nombre,  String imagepath,int capaciteReservoir) {
        return new VehiculeEssence(marque, modele,prix,Nombre,imagepath,capaciteReservoir); // Capacité réservoir par défaut
    }
}

