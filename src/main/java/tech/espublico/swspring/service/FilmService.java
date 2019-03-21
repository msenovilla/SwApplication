package tech.espublico.swspring.service;
/**
 * Service for FILM table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.List;
import tech.espublico.swspring.entity.Film;
import tech.espublico.swspring.entity.FilmJson;
import tech.espublico.swspring.entity.TopPilot;

public interface FilmService {

  /**
   * Get the list of films from the API.
   * 
   * @return List of FilmJson films
   * @throws IllegalStateException Exception
   */
  public abstract List<FilmJson> getFilmsJson() throws IllegalStateException;

  /**
   * Insert the films in DB.
   * 
   * @param films List of FilmJson films
   */
  public abstract List<Film> insertFilms(List<FilmJson> films);

  /**
   * Delete all films in DB.
   */
  public abstract void deleteAllFilms();

  /**
   * Get all films in DB.
   * 
   * @return List of Film films
   */
  public abstract List<Film> getFilms();

  /**
   * Get the top pilot of the starships that appears in the films.
   * 
   * @param films List of title films
   * @return TopPilot with the pilot name and the count
   */
  public abstract TopPilot getTopPilotByFilms(List<String> films);
}
