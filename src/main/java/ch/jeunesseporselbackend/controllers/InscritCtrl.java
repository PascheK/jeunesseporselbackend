package ch.jeunesseporselbackend.controllers;

import ch.jeunesseporselbackend.dto.InscritDTO;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.handler.ResponseHandler;
import ch.jeunesseporselbackend.service.InscritService;
import ch.jeunesseporselbackend.utils.ObjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<Object> getInscrit() {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, inscritService.getAllInscrit());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/getInscritByEvenement")
    public ResponseEntity<Object> getInscritByEvenement(int evenementId) {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, inscritService.getAllInscritByEvenementId(evenementId));
    }

    // =====================
    //         POST
    // =====================

    @PostMapping(path = "/addInscritToEvement", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addInscritToEvement(@RequestBody InscritDTO inscritDTO) {
        try {
            if (!ObjectValidator.hasNoEmptyFields(inscritDTO)) return ResponseHandler.generateResponse("Error: Il semble que des valeurs soit égale à null ou soit vide", HttpStatus.BAD_REQUEST, null);
            Inscrit i = new Inscrit(inscritDTO.getNom(), inscritDTO.getPrenom(), inscritDTO.getMail(), inscritDTO.getNbPlace(), inscritDTO.getTelephone());
            return ResponseHandler.generateResponse("Succes, vous avez été bien inscrit !", HttpStatus.OK, inscritService.addInscritToEvenement(i, inscritDTO.getEventId()));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }
}
