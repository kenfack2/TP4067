package com.tp4067.demo.model.commande;

import java.util.Date;
import java.util.List;

public class CommandeRequest {
    private List<String> vehicules;
    private Date dateLivraison;
    private String userName;
    private int idUser;
    private String paysLivraison;
    private double montant;

    public List<String> getVehicules() {
        return this.vehicules;
    }

    public void setVehicules(List<String> vehicules) {
        this.vehicules = vehicules;
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

    
}
