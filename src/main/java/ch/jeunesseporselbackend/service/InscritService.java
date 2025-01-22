package ch.jeunesseporselbackend.service;

import ch.jeunesseporselbackend.dto.NbPlaceInscritDTO;
import ch.jeunesseporselbackend.entity.Inscrit;

import java.util.List;

public interface InscritService {

    // =====================
    //         GET
    // =====================
    List<Inscrit> getAllInscrit();
    List<Inscrit> getAllInscritByEvenementId(int evenementId);
    String addInscritToEvenement(Inscrit i, int evenementId) throws Exception;

    String generateOTPCode(int idInscrit) throws Exception;

    String modifyNbPlace(NbPlaceInscritDTO i) throws Exception;
}
