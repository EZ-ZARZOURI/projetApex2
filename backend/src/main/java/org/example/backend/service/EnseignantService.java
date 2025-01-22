package org.example.backend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.backend.model.Enseignant;
import org.example.backend.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants(){
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(long id){
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        return enseignant.orElse(null);
    }

    public Enseignant saveEnseignant(Enseignant enseignant){
        return enseignantRepository.save(enseignant);
    }

    public Enseignant updateEnseignant(long id, Enseignant enseignantDetails) {
        Optional<Enseignant> existingEnseignant = enseignantRepository.findById(id);
        if (existingEnseignant.isPresent()) {
            Enseignant enseignant = existingEnseignant.get();
            enseignant.setType(enseignantDetails.getType());
            enseignant.setSexe(enseignantDetails.getSexe());
            enseignant.setNom(enseignantDetails.getNom());
            enseignant.setPrenom(enseignantDetails.getPrenom());
            enseignant.setAdresse(enseignantDetails.getAdresse());
            enseignant.setCp(enseignantDetails.getCp());
            enseignant.setVille(enseignantDetails.getVille());
            enseignant.setPays(enseignantDetails.getPays());
            enseignant.setTelPort(enseignantDetails.getTelPort());
            enseignant.setEncPersoTel(enseignantDetails.getEncPersoTel());
            enseignant.setEncUboTel(enseignantDetails.getEncUboTel());
            enseignant.setEncPersoEmail(enseignantDetails.getEncPersoEmail());
            enseignant.setEncUboEmail(enseignantDetails.getEncUboEmail());
            enseignant.setIntNoInsee(enseignantDetails.getIntNoInsee());
            enseignant.setIntSocNom(enseignantDetails.getIntSocNom());
            enseignant.setIntSocAdresse(enseignantDetails.getIntSocAdresse());
            enseignant.setIntSocCp(enseignantDetails.getIntSocCp());
            enseignant.setIntSocVille(enseignantDetails.getIntSocVille());
            enseignant.setIntSocPays(enseignantDetails.getIntSocPays());
            enseignant.setIntFonction(enseignantDetails.getIntFonction());
            enseignant.setIntProfEmail(enseignantDetails.getIntProfEmail());
            enseignant.setIntProfTel(enseignantDetails.getIntProfTel());

            return enseignantRepository.save(enseignant);
        } else {
            throw new EntityNotFoundException("Enseignant avec l'ID " + id + " non trouvé.");
        }
    }



    public void deleteEnseignant(long id){
        enseignantRepository.deleteById(id);
    }


}
