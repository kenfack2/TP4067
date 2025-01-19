package com.tp4067.demo.repository.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp4067.demo.model.users.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByAdresse(String adresse);
}
