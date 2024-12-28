package ch.jeunesseporselbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "evenement", schema = "jeunessePorselDatabase")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Size(max = 3)
    @NotNull
    @Column(name = "date", nullable = false, length = 3)
    private String date;

    @NotNull
    @Column(name = "jour", nullable = false)
    private Integer jour;

    @NotNull
    @Column(name = "nb_place", nullable = false)
    private Integer nbPlace;

    @NotNull
    @Column(name = "type_evenement", nullable = false)
    private Integer typeEvenement;

}