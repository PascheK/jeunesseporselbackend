package ch.jeunesseporselbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NbPlaceInscritDTO {
    private Integer inscritId;
    private Integer codeOTP;
    private Integer nbPlace;
}
