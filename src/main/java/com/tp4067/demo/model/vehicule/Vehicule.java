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
    private String description;
    private float prix;
    private int Nombre;

    public Vehicule id(int id) {
        setId(id);
        return this;
    }

    public Vehicule marque(String marque) {
        setMarque(marque);
        return this;
    }

    public Vehicule modele(String modele) {
        setModele(modele);
        return this;
    }

    public Vehicule description(String description) {
        setDescription(description);
        return this;
    }

    public Vehicule prix(float prix) {
        setPrix(prix);
        return this;
    }

    public Vehicule Nombre(int Nombre) {
        setNombre(Nombre);
        return this;
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
