package com.tp4067.demo.model.vehicule;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes;  
import com.fasterxml.jackson.annotation.JsonTypeInfo;  

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")  
@JsonSubTypes({  
    @JsonSubTypes.Type(value = VehiculeEssence.class, name = "ESSENCE"),  
    @JsonSubTypes.Type(value = VehiculeElectrique.class, name = "ELECTRIQUE")  
})  
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_vehicule", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String modele;
    private float prix;
    private int Nombre;
    private String imagepath;

    public Vehicule(String marque, String modele, float prix, int Nombre, String imagepath) {
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.Nombre = Nombre;
        this.imagepath = imagepath;
    }

    public Vehicule() {
    }

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

    public String getImagepath() {
        return this.imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

}
