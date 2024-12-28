package ch.jeunesseporselbackend.repository;

import ch.jeunesseporselbackend.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EvenementRepo extends JpaRepository<Evenement, Integer> {
    Evenement findById(int id);
}