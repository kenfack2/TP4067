package com.tp4067.demo.controlleur.client;

import org.springframework.web.bind.annotation.*;

import com.tp4067.demo.model.users.Client;

import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/api")
public class ClientController {

    @GetMapping("/profile")
    public String getClientProfile(HttpSession session) {
        // Récupère le client depuis la session
        Client client = (Client) session.getAttribute("clientConnecte");
        if (client == null) {
            return "Aucun client n'est connecté.";
        }

        return "Profil du client : " + client.getNom() + " (" + client.getAdresse() + ")";
    }
}
