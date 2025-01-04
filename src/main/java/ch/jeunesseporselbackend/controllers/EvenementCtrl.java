package ch.jeunesseporselbackend.controllers;


import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.handler.ResponseHandler;
import ch.jeunesseporselbackend.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getEvenement(){
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,  evenementService.getAllEvenement());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,  null);
        }
    }

    // =====================
    //         POST
    // =====================

    @PostMapping("/addEvement")
    public Evenement addEvement(Evenement evenement){
        return evenementService.addEvenement(evenement);
    }

}
