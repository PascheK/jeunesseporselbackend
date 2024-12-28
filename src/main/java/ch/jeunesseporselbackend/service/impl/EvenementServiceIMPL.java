package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.repository.EvenementRepo;
import ch.jeunesseporselbackend.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementServiceIMPL implements EvenementService {

    @Autowired
    private EvenementRepo evenementRepo;


    @Override
    public List<Evenement> getAllEvenement() {
        return evenementRepo.findAll();
    }

    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepo.save(evenement);
    }
}
