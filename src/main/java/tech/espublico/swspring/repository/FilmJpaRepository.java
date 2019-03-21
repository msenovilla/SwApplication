package tech.espublico.swspring.repository;

/**
 * Repository for FILM table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.espublico.swspring.entity.Film;
import tech.espublico.swspring.entity.TopPilot;

@Repository("filmJpaRepository")
public interface FilmJpaRepository extends JpaRepository<Film, Serializable> {
  public Film findByTitle(String title);

  public List<Film> findAllByOrderByTitleAsc();


  @Query("SELECT DISTINCT new tech.espublico.swspring.entity.TopPilot(p.name as name, count(*)"
      + " as count) FROM Person p, StarshipPilots sp, Starship s, StarshipFilm sf, Film f "
      + " WHERE p.name=sp.starshipPilotsPk.idPerson  AND sp.starshipPilotsPk.idStarship=s.name "
      + "    AND sf.starshipfilmPk.idFilm=f.title AND sf.starshipfilmPk.idStarship=s.name "
      + "    AND f.title IN (:titles) " + "GROUP BY p.name " + "ORDER BY 2 DESC")
  public List<TopPilot> getTopPilotByFilms(@Param("titles") List<String> films);
}
