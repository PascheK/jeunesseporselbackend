package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.repository.EvenementRepo;
import ch.jeunesseporselbackend.service.EmailSenderService;
import ch.jeunesseporselbackend.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> model = new HashMap<>();
        model.put("nom", "Pasche");
        model.put("prenom", "Killian");
        model.put("eventName", "Fondue");
        model.put("nbPlace", "4");
        model.put("date", "12 novembre 2025");
        model.put("numero", "12");

        return emailSenderService.sendSimpleEmail("killian.pasche7@gmail.com", "test", model, "email-template.ftl");
    }
}
