package com.tp4067.demo.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp4067.demo.model.users.Societe;
import com.tp4067.demo.repository.users.SocieteRepository;

import java.util.List;

@Service
public class SocieteService {
    @Autowired
    private SocieteRepository societeRepository;

    // Ajouter une société
    public Societe saveSociete(Societe societe) {
        return societeRepository.save(societe);
    }

    // public Integer getSocieteIdByAdresse(String adresse, String motDePasse) {
    //     Societe societe = societeRepository.findByAdresseAndMotDePasse(adresse,motDePasse)
    //             .orElseThrow(() -> new RuntimeException("Société introuvable avec l'adresse : " + adresse));
    //     return societe.getId();
    // }

    // Ajouter une filiale à une société mère
    public Societe addFiliale(int societeId, Societe filiale) {
        Societe parent = societeRepository.findById(societeId).orElseThrow(() -> new RuntimeException("Société introuvable"));
        parent.addFiliale(filiale);
        return societeRepository.save(parent); // Sauvegarde la hiérarchie
    }

    // Supprimer une filiale
    public Societe removeFiliale(int societeId, int filialeId) {
        Societe parent = societeRepository.findById(societeId).orElseThrow(() -> new RuntimeException("Société introuvable"));
        Societe filialeToRemove = parent.getFiliales().stream()
        .filter(f -> f.getId() == filialeId)
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Filiale introuvable"));
    

        parent.removeFiliale(filialeToRemove);
        return societeRepository.save(parent);
    }
    // Obtenir toutes les sociétés
    public List<Societe> getAllSocietes() {
        return societeRepository.findAll();
    }

    // Obtenir une société par ID
    public Societe getSocieteById(int id) {
        return societeRepository.findById(id).orElseThrow(() -> new RuntimeException("Société introuvable"));
    }
}
