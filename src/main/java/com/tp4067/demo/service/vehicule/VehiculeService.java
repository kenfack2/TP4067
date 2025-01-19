package com.tp4067.demo.service.vehicule;

import java.util.List;
import java.util.Optional;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp4067.demo.model.vehicule.Vehicule;
import com.tp4067.demo.model.vehicule.VehiculeElectrique;
import com.tp4067.demo.model.vehicule.VehiculeEssence;
import com.tp4067.demo.model.vehicule.VehiculeFactory;
import com.tp4067.demo.repository.vehicule.VehiculeRepository;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Vehicule createVehicule(VehiculeFactory factory,String marque, String modele,  float prix, int Nombre,String imagepath, int capacite) {
        Vehicule vehicule = factory.createVehicule(marque, modele,  prix, Nombre,imagepath, capacite);
        return vehiculeRepository.save(vehicule);
    }

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }


    public Vehicule updateVehicule(int id, Vehicule vehiculeDetails) {  
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);  
        if (optionalVehicule.isPresent()) {  
            Vehicule vehicule = optionalVehicule.get();  

            // Mettre à jour les propriétés communes  
            vehicule.setMarque(vehiculeDetails.getMarque());  
            vehicule.setModele(vehiculeDetails.getModele());  
            vehicule.setImagepath(vehiculeDetails.getImagepath());  
            vehicule.setPrix(vehiculeDetails.getPrix());  
            vehicule.setNombre(vehiculeDetails.getNombre());  

            // Mise à jour des propriétés spécifiques basé sur le type de véhicule  
            if (vehicule instanceof VehiculeEssence && vehiculeDetails instanceof VehiculeEssence) {  
                ((VehiculeEssence) vehicule).setCapaciteReservoir(((VehiculeEssence) vehiculeDetails).getCapaciteReservoir());  
            } else if (vehicule instanceof VehiculeElectrique && vehiculeDetails instanceof VehiculeElectrique) {  
                ((VehiculeElectrique) vehicule).setCapaciteBatterie(((VehiculeElectrique) vehiculeDetails).getCapaciteBatterie());  
            }  

            return vehiculeRepository.save(vehicule);  
        }  
        return null; // Ou lancez une exception si le véhicule n'est pas trouvé  
    }  
    public void deleteVehicule(int id) {
        vehiculeRepository.deleteById(id);
    }
}