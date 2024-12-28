package ch.jeunesseporselbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InscritDTO {
    private int eventId;
    private String nom;
    private String prenom;
    private String mail;
    private Integer nbPlace;
    private String telephone;
}
