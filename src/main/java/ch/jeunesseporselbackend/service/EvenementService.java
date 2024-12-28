package ch.jeunesseporselbackend.service;

import ch.jeunesseporselbackend.entity.Evenement;

import java.util.List;

public interface EvenementService {

    // =====================
    //         GET
    // =====================
    List<Evenement> getAllEvenement();

    // =====================
    //         POST
    // =====================
    Evenement addEvenement(Evenement evenement);
}
