package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.repository.EvenementRepo;
import ch.jeunesseporselbackend.repository.InscritRepo;
import ch.jeunesseporselbackend.service.InscritService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscritServiceIMPL implements InscritService {

    @Autowired
    private InscritRepo inscritRepo;
    @Autowired
    private EvenementRepo evenementRepo;

    @Override
    public List<Inscrit> getAllInscrit() {
        List<Inscrit> inscrits = inscritRepo.findAll();

        return inscrits;
    }

    @Override
    public List<Inscrit> getAllInscritByEvenementId(int evenementId) {

        Evenement evenement = evenementRepo.findById(evenementId);
        return inscritRepo.findByIdEvent(evenement);
    }

    @Override
    public String addInscritToEvenement(Inscrit i, int evenementId) {

        Evenement evenement = evenementRepo.findById(evenementId);
        i.setIdEvent(evenement);
        String res = "";
        try {
           inscritRepo.save(i);
           res = "Inscrit succesfully added";
        } catch (Exception e) {
            res = "error";

        }


        return res;
    }


}
