package com.tp4067.demo.service.commande;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp4067.demo.model.commande.CommandFactory2;
import com.tp4067.demo.model.commande.Commande2;


import com.tp4067.demo.repository.commande.CommandeRepos;


@Service
public class CommandeService2 {

    @Autowired
    private CommandeRepos commandeRepository;

    public Commande2 creerCommande2(
            CommandFactory2 factory,
            List<String> vehicules,
            Date dateLivraison,
            String userName,
            int idUser,
            String paysLivraison,
            double montant
    ) {
        
        // Créer la commande en utilisant les véhiculesDTO
        Commande2 commande = factory.createCommande2(vehicules, dateLivraison, userName, idUser, paysLivraison, montant);

        // Sauvegarder la commande
        return commandeRepository.save(commande);
    }

    public List<Commande2> getAllCommande2() {
        return commandeRepository.findAll();
    }
}
