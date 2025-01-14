package com.tp4067.demo.repository.vehicule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp4067.demo.model.vehicule.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {

}
