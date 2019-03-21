package tech.espublico.swspring.entity;
/**
 * Entity for STARSHIP_FILM table at DB
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STARSHIP_FILM")
public class StarshipFilm {

  @EmbeddedId
  private StarshipfilmPk starshipfilmPk;

  public StarshipFilm() {

  }


  public StarshipfilmPk getStarshipfilmPk() {
    return starshipfilmPk;
  }



  public void setStarshipfilmPk(StarshipfilmPk starshipfilmPk) {
    this.starshipfilmPk = starshipfilmPk;
  }



  @Embeddable
  class StarshipfilmPk implements Serializable {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -7542183358650614424L;

    @Column(name = "id_starship")
    private String idStarship;

    @Column(name = "id_film")
    private String idFilm;
  }



}
