package tech.espublico.swspring.entity;
/**
 * Entity for STARSHIP_PILOTS table at DB
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
@Table(name = "STARSHIP_PILOTS")
public class StarshipPilots {

  @EmbeddedId
  private StarshippilotsPk starshipPilotsPk;

  public StarshipPilots() {

  }



  public StarshippilotsPk getStarshipPilotsPk() {
    return starshipPilotsPk;
  }



  public void setStarshipPilotsPk(StarshippilotsPk starshipPilotsPk) {
    this.starshipPilotsPk = starshipPilotsPk;
  }



  @Embeddable
  class StarshippilotsPk implements Serializable {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 4655782395191085166L;

    @Column(name = "id_starship")
    private String idStarship;

    @Column(name = "id_person")
    private String idPerson;
  }



}
