package org.example.backend.controller;

import org.example.backend.model.Enseignant;
import org.example.backend.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ens")
public class EnseignantController {
    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    // Récupérer la liste de tous les enseignants
    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }

    // Récupérer un enseignant par son ID
    @GetMapping("/{id}")
    public Enseignant getEnseignantById(@PathVariable long id) {
        return enseignantService.getEnseignantById(id);
    }

    // Créer un nouvel enseignant
    @PostMapping
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.saveEnseignant(enseignant);
    }

    // Mettre à jour un enseignant existant
    @PutMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable long id, @RequestBody Enseignant enseignant) {
        return enseignantService.updateEnseignant(id,enseignant);
    }

    // Supprimer un enseignant par son ID
    @DeleteMapping("/{id}")
    public void deleteEnseignant(@PathVariable long id) {
        enseignantService.deleteEnseignant(id);
    }
}
