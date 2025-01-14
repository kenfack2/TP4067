package com.tp4067.demo.controlleur.vehicule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tp4067.demo.model.vehicule.ElectriqueVehiculeFactory;
import com.tp4067.demo.model.vehicule.EssenceVehiculeFactory;
import com.tp4067.demo.model.vehicule.Vehicule;
import com.tp4067.demo.service.vehicule.VehiculeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private EssenceVehiculeFactory essenceVehiculeFactory;

    @Autowired
    private ElectriqueVehiculeFactory electriqueVehiculeFactory;

    @PostMapping("/essence")
    public Vehicule createEssenceVehicule(@RequestBody Map<String, Object> payload) {  
        try {
            String marque = (String) payload.get("marque");
            String modele = (String) payload.get("modele");
            String description = (String) payload.get("description");
    
            if (payload.get("prix") == null) {
                throw new IllegalArgumentException("Le champ 'prix' est obligatoire.");
            }
            int prix = ((Number) payload.get("prix")).intValue();
    
            if (payload.get("Nombre") == null) {
                throw new IllegalArgumentException("Le champ 'Nombre' est obligatoire.");
            }
            int nombre = ((Number) payload.get("Nombre")).intValue();
    
            if (payload.get("capaciteReservoir") == null) {
                throw new IllegalArgumentException("Le champ 'capaciteReservoir' est obligatoire.");
            }
            int capaciteReservoir = ((Number) payload.get("capaciteReservoir")).intValue();
    
            return vehiculeService.createVehicule(
                essenceVehiculeFactory, marque, modele, description, prix, nombre, capaciteReservoir);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Les types des champs ne sont pas valides : " + e.getMessage());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Certains champs obligatoires sont manquants : " + e.getMessage());
        }
    }
    
    
@PostMapping("/electrique")
public Vehicule createElectriqueVehicule(@RequestBody Map<String, Object> payload) {  
    try {
        String marque = (String) payload.get("marque");
        String modele = (String) payload.get("modele");
        String description = (String) payload.get("description");

        if (payload.get("prix") == null) {
            throw new IllegalArgumentException("Le champ 'prix' est obligatoire.");
        }
        int prix = ((Number) payload.get("prix")).intValue();

        if (payload.get("Nombre") == null) {
            throw new IllegalArgumentException("Le champ 'Nombre' est obligatoire.");
        }
        int nombre = ((Number) payload.get("Nombre")).intValue();

        if (payload.get("capaciteBatterie") == null) {
            throw new IllegalArgumentException("Le champ 'capaciteBatterie' est obligatoire.");
        }
        int capaciteBatterie = ((Number) payload.get("capaciteBatterie")).intValue();

        return vehiculeService.createVehicule(
            electriqueVehiculeFactory, marque, modele, description, prix, nombre, capaciteBatterie);
    } catch (ClassCastException e) {
        throw new IllegalArgumentException("Les types des champs ne sont pas valides : " + e.getMessage());
    } catch (NullPointerException e) {
        throw new IllegalArgumentException("Certains champs obligatoires sont manquants : " + e.getMessage());
    }
}


    @GetMapping("/getallvehicule")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable int id, @RequestBody Vehicule vehiculeDetails) {  
        Vehicule updatedVehicule = vehiculeService.updateVehicule(id, vehiculeDetails);  
        if (updatedVehicule != null) {  
            return ResponseEntity.ok(updatedVehicule);  
        }  
        return ResponseEntity.notFound().build(); // En cas de véhicule non trouvé  
    }  


    @DeleteMapping("supprimer/{id}")
    public String deleteVehicule(@PathVariable int id) {
        vehiculeService.deleteVehicule(id);
        return "Véhicule supprimé avec succès.";
    }

}
