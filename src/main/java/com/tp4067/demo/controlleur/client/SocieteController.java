package com.tp4067.demo.controlleur.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tp4067.demo.model.users.Societe;
import com.tp4067.demo.service.client.SocieteService;

import java.util.List;

@RestController
@RequestMapping("/societes")
public class SocieteController {
    @Autowired
    private SocieteService societeService;

    @PostMapping("/create")
    public ResponseEntity<Societe> createSociete(@RequestBody Societe societe) {
        return ResponseEntity.ok(societeService.saveSociete(societe));
    }

    @PostMapping("/{id}/filiales")
    public ResponseEntity<Societe> addFiliale(@PathVariable int id, @RequestBody Societe filiale) {
        return ResponseEntity.ok(societeService.addFiliale(id, filiale));
    }

    @DeleteMapping("/{id}/filiales/{filialeId}")
    public ResponseEntity<Societe> removeFiliale(@PathVariable int id, @PathVariable int filialeId) {
        return ResponseEntity.ok(societeService.removeFiliale(id, filialeId));
    }

    @GetMapping
    public ResponseEntity<List<Societe>> getAllSocietes() {
        return ResponseEntity.ok(societeService.getAllSocietes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Societe> getSocieteById(@PathVariable int id) {
        return ResponseEntity.ok(societeService.getSocieteById(id));
    }
}
