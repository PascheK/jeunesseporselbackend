package ch.jeunesseporselbackend.repository;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface InscritRepo extends JpaRepository<Inscrit, Integer> {
    List<Inscrit> findByIdEvent(@NotNull Evenement idEvent);
    @Query(value = "SELECT inscrit.id_inscrit FROM inscrit WHERE inscrit.nom = :nom  and inscrit.prenom = :prenom  and inscrit.mail = :mail and inscrit.id_event = :event", nativeQuery = true)
    Optional<Integer> findInscritIdByNomAndPrenomAndMail(@Param("nom") String nom, @Param("prenom") String prenom, @Param("mail") String mail, @Param("event") int evenement);
}