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


    public PersonneOrdinaire connecter(String adresse, String motDePasse, HttpSession session) {
        PersonneOrdinaire client = personneRepository.findByAdresseAndMotDePasse(adresse, motDePasse)
            .orElseThrow(() -> new RuntimeException("Adresse ou mot de passe incorrect"));

        // Enregistrer l'utilisateur dans la session
        session.setAttribute("utilisateur", client);
        return client;
    }

    public PersonneOrdinaire obtenirUtilisateurConnecte(HttpSession session) {
        return (PersonneOrdinaire) session.getAttribute("utilisateur");
    }

    public void deconnecter(HttpSession session) {
        session.removeAttribute("utilisateur");
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
