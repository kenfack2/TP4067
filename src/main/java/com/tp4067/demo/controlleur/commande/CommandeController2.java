package com.tp4067.demo.controlleur.commande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp4067.demo.model.commande.CommandFactory2;
import com.tp4067.demo.model.commande.Commande2;
import com.tp4067.demo.model.commande.CommandeRequest;
import com.tp4067.demo.service.commande.CommandeService2;
@RestController
@RequestMapping("/commandecontroller2")
public class CommandeController2 {
    @Autowired
    private CommandeService2 commandeService;

    @Autowired
    private CommandFactory2 commandeFactoryCameroun; // Factory utilisée par défaut


@PostMapping("/create")
public ResponseEntity<Commande2> createCommande(@RequestBody CommandeRequest commandeRequest) {
    Commande2 commande = commandeService.creerCommande2(
            commandeFactoryCameroun,
            commandeRequest.getVehicules(),
            commandeRequest.getDateLivraison(),
            commandeRequest.getUserName(),
            commandeRequest.getIdUser(),
            commandeRequest.getPaysLivraison(),
            commandeRequest.getMontant()
    );

    return ResponseEntity.ok(commande);
}


    /**
     * Méthode pour récupérer toutes les commandes.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Commande2>> getAllCommandes() {
        List<Commande2> commandes = commandeService.getAllCommande2();
        return ResponseEntity.ok(commandes);
    }
}  