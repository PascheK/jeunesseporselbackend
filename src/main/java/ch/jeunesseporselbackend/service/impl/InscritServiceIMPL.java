package ch.jeunesseporselbackend.service.impl;

import ch.jeunesseporselbackend.dto.NbPlaceInscritDTO;
import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import ch.jeunesseporselbackend.repository.EvenementRepo;
import ch.jeunesseporselbackend.repository.InscritRepo;
import ch.jeunesseporselbackend.service.EmailSenderService;
import ch.jeunesseporselbackend.service.InscritService;
import ch.jeunesseporselbackend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class InscritServiceIMPL implements InscritService {

    @Autowired
    private InscritRepo inscritRepo;
    @Autowired
    private EvenementRepo evenementRepo;

    @Autowired
    private EmailSenderService emailSenderService;

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
        try {
            Evenement evenement = evenementRepo.findById(evenementId);
            if (evenement == null) throw new Exception("L'evenement rechercher n'existe pas !");
            i.setIdEvent(evenement);
            if (inscritRepo.findInscritIdByNomAndPrenomAndMail(i.getNom(), i.getPrenom(), i.getMail(), i.getIdEvent().getId()).isPresent())
                throw new Exception("Vous êtes déjà inscrit à cette événement!");
            if (evenement.getNbPlace() < i.getNbPlace())
                throw new Exception("Il ne reste malheureusement plus que " + evenement.getNbPlace() + " places! ");
            evenement.setNbPlace(evenement.getNbPlace() - i.getNbPlace());
            evenementRepo.save(evenement);
            inscritRepo.save(i);
            Map<String, Object> model = new HashMap<>();
            model.put("nom", i.getNom());
            model.put("prenom", i.getPrenom());
            model.put("eventName", evenement.getNom());
            model.put("nbPlace", i.getNbPlace());
            model.put("date", evenement.getJour()+" "+evenement.getDate()+" 2025");
            model.put("numero", i.getId());

            if( emailSenderService.sendSimpleEmail(i.getMail(), "Inscription pour : "+evenement.getNom(), model , "email-template.ftl" )){
                return "L'inscription c'est bien passé !";
            }else{
                throw new Exception("Le mail n'as pas été envoyé ");
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public String generateOTPCode(int idInscrit) throws Exception {
        try{
            Inscrit i = inscritRepo.findById(idInscrit).get();
            Random random = new Random();
            int code = 100000 + random.nextInt(900000);
            i.setCode_otp(code);
            i.setCode_otp_datetime(LocalDateTime.now());
            inscritRepo.save(i);
            Map<String, Object> model = new HashMap<>();
            model.put("nom", i.getNom());
            model.put("prenom", i.getPrenom());
            model.put("code", code);
            if( emailSenderService.sendSimpleEmail(i.getMail(), "Code d'authentification pour modification de place", model , "code-confirmation.ftl")){
                return "Le code à bien été envoyé par mail!";
            }else{
                throw new Exception("Le mail n'as pas été envoyé ");
            }
        }catch (Exception e){
            throw new Exception(e);
        }

    }

    @Override
    public String modifyNbPlace(NbPlaceInscritDTO iData) {

        try {

            Inscrit i = inscritRepo.findById(iData.getInscritId()).get();
            if(!Utils.isDateOlderThan5Minutes(i.getCode_otp_datetime())) throw new Exception("Le code est plus valable");
            if (i.getCode_otp() == 0) throw new Exception("Le code est plus valable");
            if(!Objects.equals(i.getCode_otp(), iData.getCodeOTP())) throw new Exception("Le code n'est pas identitque");



            i.setNbPlace(iData.getNbPlace());
            i.setCode_otp_datetime(LocalDateTime.now().minusMinutes(30));
            i.setCode_otp(0);
            inscritRepo.save(i);

            Map<String, Object> model = new HashMap<>();
            model.put("nom", i.getNom());
            model.put("prenom", i.getPrenom());
            model.put("eventName", i.getIdEvent().getNom());
            model.put("nbPlace", i.getNbPlace());
            model.put("date", i.getIdEvent().getJour()+" "+i.getIdEvent().getDate()+" 2025");
            model.put("numero", i.getId());
            if( emailSenderService.sendSimpleEmail(i.getMail(), "Modification d'inscription", model , "changement-template.ftl")){
                return "La modification a bien fonctionné!";
            }else{
                throw new Exception("Le mail n'as pas été envoyé ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
