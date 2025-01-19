package com.tp4067.demo.controlleur.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tp4067.demo.model.users.PersonneOrdinaire;
import com.tp4067.demo.model.users.Societe;
import com.tp4067.demo.service.client.AuthService;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String adresse, @RequestParam String motDePasse, HttpSession session) {
        try {
            Object utilisateur = authService.connecter(adresse, motDePasse, session);
            return ResponseEntity.ok(utilisateur);  // Retourne le profil de l'utilisateur connecté
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/profil")
    public ResponseEntity<Object> getProfil(HttpSession session) {
        Object utilisateur = authService.obtenirUtilisateurConnecte(session);
        if (utilisateur == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non connecté");
        }
        return ResponseEntity.ok(utilisateur);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(HttpSession session) {
        authService.deconnecter(session);
        return ResponseEntity.ok("Déconnexion réussie");
    }


    @PostMapping("/loginsociete")
    public ResponseEntity<Object> loginsociete(@RequestParam String adresse, @RequestParam String motDePasse, HttpSession session) {
        try {
            Societe client = authService.connectersociete(adresse, motDePasse, session);
            return ResponseEntity.ok(client);  // Retourne le profil de la societe connecté
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/profilsociete")
    public ResponseEntity<Object> getProfilsociete(HttpSession session) {
        Societe client = authService.obtenirSocieteConnecte(session);
        if (client == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non connecté");
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping("/logoutsociete")
    public ResponseEntity<Object> logoutsociete(HttpSession session) {
        authService.deconnecterSociete(session);
        return ResponseEntity.ok("Déconnexion réussie");
    }
}
