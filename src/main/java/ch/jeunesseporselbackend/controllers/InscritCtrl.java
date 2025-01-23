package ch.jeunesseporselbackend.controllers;

import ch.jeunesseporselbackend.dto.IdInscritDTO;
import ch.jeunesseporselbackend.dto.InscritDTO;
import ch.jeunesseporselbackend.dto.NbPlaceInscritDTO;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.handler.ResponseHandler;
import ch.jeunesseporselbackend.service.InscritService;
import ch.jeunesseporselbackend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            if (!Utils.hasNoEmptyFields(inscritDTO)) return ResponseHandler.generateResponse("Error: Il semble que des valeurs soit égale à null ou soit vide", HttpStatus.BAD_REQUEST, null);
            Inscrit i = new Inscrit(inscritDTO.getNom(), inscritDTO.getPrenom(), inscritDTO.getMail(), inscritDTO.getNbPlace(), inscritDTO.getTelephone());
            return ResponseHandler.generateResponse("Succes, vous avez été bien inscrit !", HttpStatus.OK, inscritService.addInscritToEvenement(i, inscritDTO.getEventId()));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

    @PostMapping(path = "/generateOTPCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> generateOTPCode(@RequestBody IdInscritDTO idInscrit) {
        try {
            if (idInscrit.getIdInscrit() < 0) return ResponseHandler.generateResponse("Error: Il semble que des valeurs soit égale à null ou soit vide", HttpStatus.BAD_REQUEST, null);

            return ResponseHandler.generateResponse("Succes, le code d'authentification a bien été envoyée!", HttpStatus.OK, inscritService.generateOTPCode(idInscrit.getIdInscrit()) );
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @PutMapping(path = "/modifyNbPlaceForInscrit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> putNbPlaceByIdInscrit(@RequestBody NbPlaceInscritDTO i) {
        try {
            if (!Utils.hasNoEmptyFields(i)) return ResponseHandler.generateResponse("Error: Il semble que des valeurs soit égale à null ou soit vide", HttpStatus.BAD_REQUEST, null);

            return ResponseHandler.generateResponse("Succes, le code d'authentification a bien été envoyée!", HttpStatus.OK, inscritService.modifyNbPlace(i) );
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

}
