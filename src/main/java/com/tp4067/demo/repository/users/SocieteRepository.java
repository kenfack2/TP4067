package com.tp4067.demo.repository.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp4067.demo.model.users.Societe;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Integer> {
    Optional<Societe> findByAdresseAndMotDePasse(String adresse, String motDePasse);
}
