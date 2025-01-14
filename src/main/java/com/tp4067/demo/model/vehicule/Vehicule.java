package com.tp4067.demo.model.vehicule;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_vehicule", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String modele;
    private String description;
    private float prix;
    private int Nombre;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return this.modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return this.prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNombre() {
        return this.Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }



    public Vehicule(String marque, String modele, String description, float prix, int Nombre) {
        this.marque = marque;
        this.modele = modele;
        this.description = description;
        this.prix = prix;
        this.Nombre = Nombre;
    }

    public Vehicule() {
    }
    
}
