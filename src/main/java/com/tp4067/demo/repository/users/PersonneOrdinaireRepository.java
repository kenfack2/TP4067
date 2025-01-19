package com.tp4067.demo.repository.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp4067.demo.model.users.PersonneOrdinaire;

@Repository
public interface PersonneOrdinaireRepository extends JpaRepository<PersonneOrdinaire,Integer > {
    Optional<PersonneOrdinaire> findByAdresseAndMotDePasse(String adresse, String motDePasse);

}
