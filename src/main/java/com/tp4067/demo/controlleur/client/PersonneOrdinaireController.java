package com.tp4067.demo.controlleur.client;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tp4067.demo.model.users.PersonneOrdinaire;
import com.tp4067.demo.service.client.PersonneOrdinaireService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
@RequestMapping("/api/personnes")
public class PersonneOrdinaireController {

    @Autowired
    private PersonneOrdinaireService service;

    // Ajouter une nouvelle personne
    @PostMapping("create")
    public PersonneOrdinaire ajouterPersonne(@RequestBody PersonneOrdinaire personne) {
        return service.ajouterPersonneOrdinaire(personne);
    }

    @GetMapping("/profil")
    public ResponseEntity<Object> afficherProfilParAdresseEtMotDePasse(@RequestParam String adresse, @RequestParam String motDePasse) {
        try {
            // Appel du service pour obtenir le profil
            PersonneOrdinaire profil = service.obtenirProfilParAdresseEtMotDePasse(adresse, motDePasse);
            return ResponseEntity.ok(profil);
        } catch (RuntimeException e) {
            // Si personne non trouvée ou mot de passe incorrect
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    

    // Récupérer une personne par ID
    @GetMapping("/{id}")
    public PersonneOrdinaire obtenirPersonne(@PathVariable int id) {
        return service.obtenirPersonneParId(id);
    }

    // Récupérer toutes les personnes
    @GetMapping
    public List<PersonneOrdinaire> obtenirToutesLesPersonnes() {
        return service.obtenirToutesLesPersonnes();
    }

    // Mettre à jour une personne
    @PutMapping("/{id}")
    public PersonneOrdinaire mettreAJourPersonne(@PathVariable int id, @RequestBody PersonneOrdinaire detailsPersonne) {
        return service.mettreAJourPersonne(id, detailsPersonne);
    }

    // Supprimer une personne par ID
    @DeleteMapping("/{id}")
    public String supprimerPersonne(@PathVariable int id) {
        service.supprimerPersonneParId(id);
        return "Personne supprimée avec succès !";
    }
}
