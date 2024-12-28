package ch.jeunesseporselbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inscrit", schema = "jeunessePorselDatabase")
public class Inscrit {
    public Inscrit() {

    }

    public Inscrit(String nom, String prenom, String mail, Integer nbPlace, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.nbPlace = nbPlace;
        this.telephone = telephone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscrit", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @NotNull
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Size(max = 255)
    @NotNull
    @Column(name = "mail", nullable = false)
    private String mail;

    @NotNull
    @Column(name = "nb_place", nullable = false)
    private Integer nbPlace;

    @Size(max = 20)
    @NotNull
    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_event", nullable = false)
    private Evenement idEvent;


}