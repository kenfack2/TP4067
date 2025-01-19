package com.tp4067.demo.model.commande;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tp4067.demo.model.commande.Commande2;

@Component
public class CommandeFactoryCameroun implements CommandFactory2 {
        @Override  
    public Commande2 createCommande2(List<String> nomvehicules, Date dateLivraison, String userName, int idUser, String paysLivraison, double montant) {  
        return new CommandeCameroun(nomvehicules, dateLivraison, userName, idUser, paysLivraison, montant);  
    }  
}
