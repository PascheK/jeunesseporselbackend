package ch.jeunesseporselbackend.controllers;

import ch.jeunesseporselbackend.dto.InscritDTO;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.handler.ResponseHandler;
import ch.jeunesseporselbackend.service.InscritService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/inscrit")
public class InscritCtrl {

    @Autowired
    private InscritService inscritService;

    // =====================
    //         GET
    // =====================
    @GetMapping("/getInscrit")
    public ResponseEntity<Object> getInscrit(){
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,  inscritService.getAllInscrit());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,  null);
        }
    }

    @GetMapping("/getInscritByEvenement")
    public ResponseEntity<Object> getInscritByEvenement(int evenementId){
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, inscritService.getAllInscritByEvenementId(evenementId));
    }

    // =====================
    //         POST
    // =====================

    @PostMapping("/addInscritToEvement")
    public String addInscritToEvement(InscritDTO inscritDTO){
        Inscrit i = new Inscrit(inscritDTO.getNom(), inscritDTO.getPrenom(), inscritDTO.getMail(), inscritDTO.getNbPlace(), inscritDTO.getTelephone());
        i.setNom(inscritDTO.getNom());
        return inscritService.addInscritToEvenement(i, inscritDTO.getEventId());
    }
}
