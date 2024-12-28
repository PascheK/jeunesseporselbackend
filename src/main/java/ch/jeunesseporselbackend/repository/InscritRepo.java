package ch.jeunesseporselbackend.repository;

import ch.jeunesseporselbackend.entity.Evenement;
import ch.jeunesseporselbackend.entity.Inscrit;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface InscritRepo extends JpaRepository<Inscrit, Integer> {
    List<Inscrit> findByIdEvent(@NotNull Evenement idEvent);
}