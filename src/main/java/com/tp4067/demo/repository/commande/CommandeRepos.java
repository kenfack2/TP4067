package com.tp4067.demo.repository.commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp4067.demo.model.commande.Commande2;

@Repository
public interface CommandeRepos extends JpaRepository<Commande2, Integer> {

}
