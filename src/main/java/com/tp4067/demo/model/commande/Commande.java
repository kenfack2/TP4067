package com.tp4067.demo.model.commande;


import jakarta.persistence.*;

@Entity
@Table(name = "commande")
public class Commande{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pays;
    private String number;
    private float montant;

    public Commande(int id, String pays, String number, float montant) {
        this.id = id;
        this.pays = pays;
        this.number = number;
        this.montant = montant;
    }

    public Commande() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commande id(int id) {
        setId(id);
        return this;
    }

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getMontant() {
        return this.montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

}