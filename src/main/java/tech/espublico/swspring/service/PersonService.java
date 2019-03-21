package tech.espublico.swspring.service;
/**
 * Service for PERSON table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.List;
import tech.espublico.swspring.entity.Person;
import tech.espublico.swspring.entity.PersonJson;

public interface PersonService {
  /**
   * Get the list of people from the API.
   * 
   * @return List of PersonJson people
   * @throws IllegalStateException Exception
   */
  public abstract List<PersonJson> getPeopleJson() throws IllegalStateException;
  
  /**
   * Delete all people in DB.
   */
  public abstract void deleteAllPeople();
  
  /**
   * Get all people in DB.
   * 
   * @return List of Person people
   */
  public abstract List<Person> getPeople();
  
  /**
   * Insert the list of people in DB.
   * 
   * @param people List of PersonJson to insert
   */
  public abstract void insertPeople(List<PersonJson> people);
}
