package com.tp4067.demo.model.users;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Societe extends Client {
    private String siret;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private List<Societe> filiales = new ArrayList<>();

    // Getters et Setters
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public List<Societe> getFiliales() {
        return filiales;
    }

    public void setFiliales(List<Societe> filiales) {
        this.filiales = filiales;
    }

    public void addFiliale(Societe filiale) {
        this.filiales.add(filiale);
    }

    public void removeFiliale(Societe filiale) {
        this.filiales.remove(filiale);
    }
}
