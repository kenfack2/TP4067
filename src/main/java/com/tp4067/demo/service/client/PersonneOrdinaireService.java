package com.tp4067.demo.service.client;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp4067.demo.model.users.PersonneOrdinaire;
import com.tp4067.demo.repository.users.PersonneOrdinaireRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneOrdinaireService {

    @Autowired
    private PersonneOrdinaireRepository repository;

    // Ajouter une nouvelle personne ordinaire
    public PersonneOrdinaire ajouterPersonneOrdinaire(PersonneOrdinaire personne) {
        return repository.save(personne);
    }

    public PersonneOrdinaire obtenirProfilParAdresseEtMotDePasse(String adresse, String motDePasse) {
        // Rechercher la personne ordinaire par adresse et mot de passe
        return repository.findByAdresseAndMotDePasse(adresse, motDePasse)
            .orElseThrow(() -> new RuntimeException("Personne introuvable avec l'adresse ou le mot de passe incorrect"));
    }
    // Récupérer une personne ordinaire par son ID
    public PersonneOrdinaire obtenirPersonneParId(int id) {
        Optional<PersonneOrdinaire> personne = repository.findById(id);
        return personne.orElseThrow(() -> new RuntimeException("Personne introuvable avec l'ID : " + id));
    }

    // Récupérer toutes les personnes ordinaires
    public List<PersonneOrdinaire> obtenirToutesLesPersonnes() {
        return repository.findAll();
    }

    // Mettre à jour les informations d'une personne
    public PersonneOrdinaire mettreAJourPersonne(int id, PersonneOrdinaire detailsPersonne) {
        PersonneOrdinaire personneExistante = obtenirPersonneParId(id);
        personneExistante.setNom(detailsPersonne.getNom());
        personneExistante.setAdresse(detailsPersonne.getAdresse());
        personneExistante.setMotDePasse(detailsPersonne.getMotDePasse());
        personneExistante.setDateNaissance(detailsPersonne.getDateNaissance());
        return repository.save(personneExistante);
    }

    // Supprimer une personne ordinaire par son ID
    public void supprimerPersonneParId(int id) {
        repository.deleteById(id);
    }
}
