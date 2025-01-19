package com.tp4067.demo.service.client;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp4067.demo.model.users.PersonneOrdinaire;
import com.tp4067.demo.model.users.Societe;
import com.tp4067.demo.repository.users.PersonneOrdinaireRepository;
import com.tp4067.demo.repository.users.SocieteRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {

    @Autowired
    private PersonneOrdinaireRepository personneRepository;

    @Autowired
    private SocieteRepository societeRepository;


    public Object connecter(String adresse, String motDePasse, HttpSession session) {
         // Vérifier si c'est une Societe
            Societe societe = societeRepository.findByAdresseAndMotDePasse(adresse, motDePasse)
                .orElseThrow(() -> new RuntimeException("Adresse ou mot de passe incorrect"));
    
                // Vérifier si l'adresse appartient à une PersonneOrdinaire ou une Filiale

                if (societe != null) {
                    // L'utilisateur est une Societe
                    session.setAttribute("societe", societe);
                    return societe;
                }
        PersonneOrdinaire client = personneRepository.findByAdresseAndMotDePasse(adresse, motDePasse)
            .orElseThrow(() -> new RuntimeException("Adresse ou mot de passe incorrect"));

        // Enregistrer l'utilisateur dans la session
        session.setAttribute("utilisateur", client);
        return client;
    }

    public Object obtenirUtilisateurConnecte(HttpSession session) {
        Object utilisateur = session.getAttribute("societe");
        if (utilisateur == null) {
            utilisateur = session.getAttribute("personneOrdinaire");
        }
        return utilisateur;
    }

    public void deconnecter(HttpSession session) {
        session.removeAttribute("societe");
        session.removeAttribute("personneOrdinaire");
    }
    
    public Societe connectersociete(String adresse, String motDePasse, HttpSession session) {
        Societe client = societeRepository.findByAdresseAndMotDePasse(adresse, motDePasse)
            .orElseThrow(() -> new RuntimeException("Adresse ou mot de passe incorrect"));

        // Enregistrer l'utilisateur dans la session
        session.setAttribute("utilisateur", client);
        return client;
    }

    public Societe obtenirSocieteConnecte(HttpSession session) {
        return (Societe) session.getAttribute("utilisateur");
    }

    public void deconnecterSociete(HttpSession session) {
        session.removeAttribute("utilisateur");
    }
}
