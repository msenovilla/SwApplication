package tech.espublico.swspring.service;
/**
 * Service for STARSHIP table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.List;
import tech.espublico.swspring.entity.Starship;

public interface StarshipService {
  /**
   * Get the list of starship from the API.
   * 
   * @return List of Starship starship
   */
  public abstract List<Starship> getStarshipsJson();

  /**
   * Insert the list of starship in DB.
   * 
   * @param starship List of Starship to insert
   */
  public abstract void insertStarships(List<Starship> starship);

  /**
   * Delete all starship in DB.
   */
  public abstract void deleteAllStarship();
}
