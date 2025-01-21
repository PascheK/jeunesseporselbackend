package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.repository.EvenementRepo;
import ch.jeunesseporselbackend.repository.InscritRepo;
import ch.jeunesseporselbackend.service.InscritService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscritServiceIMPL implements InscritService {

    @Autowired
    private InscritRepo inscritRepo;
    @Autowired
    private EvenementRepo evenementRepo;

    @Override
    public List<Inscrit> getAllInscrit() {
        try {
            return inscritRepo.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Inscrit> getAllInscritByEvenementId(int evenementId) {
        try {
            Evenement evenement = evenementRepo.findById(evenementId);
            return inscritRepo.findByIdEvent(evenement);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String addInscritToEvenement(Inscrit i, int evenementId) throws Exception {
        try{
            Evenement evenement = evenementRepo.findById(evenementId);
            evenement = null;
                if(evenement == null) throw new Exception("L'evenement rechercher n'existe pas !");
            i.setIdEvent(evenement);

        } catch (Exception e) {
            throw new Exception(e);
        }



    // Regarde si l'inscrit est déja inscrit à l'evenement en question


    // Regarde si il y a assez de places.

        String res = "";
        try {
            inscritRepo.save(i);
            res = "Inscrit succesfully added";
        } catch (Exception e) {
            res = "error";

        }


        return res;
    }


}
