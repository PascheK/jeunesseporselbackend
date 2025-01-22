package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.repository.EvenementRepo;
import ch.jeunesseporselbackend.service.EmailSenderService;
import ch.jeunesseporselbackend.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementServiceIMPL implements EvenementService {

    @Autowired
    private EvenementRepo evenementRepo;

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public List<Evenement> getAllEvenement() {
        try {
            return evenementRepo.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepo.save(evenement);
    }

    @Override
    public boolean test() throws Exception {

        return emailSenderService.sendSimpleEmail("killian.pasche7@gmail.com", "test", null);
    }
}
