package com.tp4067.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp4067.demo.model.Users;
import com.tp4067.demo.repository.UseRepository;


@Service
@Transactional
public class UserService {
    @Autowired
    UseRepository userRepos;
    public void adduser(Users user){
    userRepos.save(user);
    }
    
// recherche d un utilisateur
public Users getUsers(int id) {
return userRepos.findById(id).orElse(null);
}

// recupere les utilisateur
public List<Users> getAllUsers() {
    return userRepos.findAll();
    }
    
// suprimer un utilisateur
public List<Users> deleteUsers(int id) {
    userRepos.deleteById(id);
    return userRepos.findAll();
    }

    // Modifier un utilisateur
    public Users updateUser(int id, Users updatedUser) {
        return userRepos.findById(id).map(existingUser -> {
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepos.save(existingUser);
        }).orElse(null); // Retourne null si l'utilisateur n'existe pas
    }

}
