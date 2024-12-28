package ch.jeunesseporselbackend.controllers;


import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/evenement")
public class EvenementCtrl {

    @Autowired
    private EvenementService evenementService;

    // =====================
    //         GET
    // =====================
    @GetMapping("/")
    public List<Evenement> getEvenement(){
        return evenementService.getAllEvenement();
    }

    // =====================
    //         POST
    // =====================

    @PostMapping("/addEvement")
    public Evenement addEvement(Evenement evenement){
        return evenementService.addEvenement(evenement);
    }

}
