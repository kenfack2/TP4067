package com.tp4067.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tp4067.demo.model.Users;

@RepositoryRestResource
public interface UseRepository extends JpaRepository<Users, Integer> {

}
