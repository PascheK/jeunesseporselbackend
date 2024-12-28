package ch.jeunesseporselbackend.repository;

import ch.jeunesseporselbackend.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LoginRepo extends JpaRepository<Login, Integer> {
}
