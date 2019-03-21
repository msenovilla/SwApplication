package tech.espublico.swspring.repository;

/**
 * Repository for STARSHIP table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.espublico.swspring.entity.Starship;

@Repository("starshipJpaRepository")
public interface StarshipJpaRepository extends JpaRepository<Starship, Serializable> {
  public Starship findByName(String name);
}
