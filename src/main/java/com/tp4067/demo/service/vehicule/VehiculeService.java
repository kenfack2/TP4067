package com.tp4067.demo.service.vehicule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp4067.demo.model.vehicule.Vehicule;
import com.tp4067.demo.model.vehicule.VehiculeFactory;
import com.tp4067.demo.repository.vehicule.VehiculeRepository;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Vehicule createVehicule(VehiculeFactory factory,String marque, String modele, String description, float prix, int Nombre, int capacite) {
        Vehicule vehicule = factory.createVehicule(marque, modele, description, prix, Nombre, capacite);
        return vehiculeRepository.save(vehicule);
    }

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public Vehicule updateVehicule(int id, Vehicule updatedVehicule) {
        return vehiculeRepository.findById(id).map(existingVehicule -> {
            existingVehicule.setMarque(updatedVehicule.getMarque());
            existingVehicule.setModele(updatedVehicule.getModele());
            existingVehicule.setDescription(updatedVehicule.getDescription());
            existingVehicule.setPrix(updatedVehicule.getPrix());
            existingVehicule.setNombre(updatedVehicule.getNombre());
            return vehiculeRepository.save(existingVehicule);
        }).orElseThrow(() -> new RuntimeException("Véhicule introuvable"));
    }

    public void deleteVehicule(int id) {
        vehiculeRepository.deleteById(id);
    }
}