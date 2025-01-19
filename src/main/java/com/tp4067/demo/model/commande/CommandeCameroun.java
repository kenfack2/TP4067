package com.tp4067.demo.model.commande;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;


@Entity
public class CommandeCameroun extends Commande2 {

    public CommandeCameroun(List<String> nomvehicules, Date dateLivrason, String userName, int idUser, String paysLivraison, double montant) {  
        super(nomvehicules, dateLivrason, userName, idUser, paysLivraison, montant);  
    }  

    public CommandeCameroun() {
    }

    // Implémentation de la méthode abstraite  
    @Override  
    protected double calculMontantDeBase() {  
        // Calcul du montant de base apres taxe  
        return getMontant()*1.3;
    }  
}