package com.tp4067.demo.model.commande;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;


@Entity
public abstract class Commande2 {  
    
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;  
    
    @ElementCollection 
    private List<String> nomvehicules;  
    private Date dateLivraison;  
    private String userName;  
    private int idUser;  
    private String status;  // "EN_COURS", "VALIDÉE", "LIVRÉE"  
    private String paysLivraison;  // Pays de livraison  
    private double montant; // Montant total après taxes  

    public Commande2() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getNomvehicules() {
        return this.nomvehicules;
    }

    public void setNomvehicules(List<String> nomvehicules) {
        this.nomvehicules = nomvehicules;
    }

    public Date getDateLivraison() {
        return this.dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaysLivraison() {
        return this.paysLivraison;
    }

    public void setPaysLivraison(String paysLivraison) {
        this.paysLivraison = paysLivraison;
    }

    public double getMontant() {
        return this.montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }


    // Constructeur protégé pour la factory  
    public Commande2(List<String> nomvehicules, Date dateLivraison, String userName, int idUser, String paysLivraison, double montant) {  
        this.nomvehicules = nomvehicules;  
        this.dateLivraison = dateLivraison;  
        this.userName = userName;  
        this.idUser = idUser;  
        this.paysLivraison = paysLivraison;  
        this.status = "EN_COURS"; // Initialement en cours  
    }  


  // Template method pour calculer le montant total  
public final double calculMontant() {  
    double montantDeBase = calculMontantDeBase(); // Appel à la méthode protégée  
    return appliquerTaxes(montantDeBase); // Appliquer les taxes  
}

// Méthode protégée à implémenter dans les sous-classes  
protected abstract double calculMontantDeBase();  

protected double appliquerTaxes(double montant) { 

     // Applique 20% de taxe 
        return montant*1.20; // Pas de taxe pour d'autres pays  
    }  
}