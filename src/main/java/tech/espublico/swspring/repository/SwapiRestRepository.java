package tech.espublico.swspring.repository;
/**
 * Repository class for all REST callings to SWAPI 
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tech.espublico.swspring.entity.FilmJson;
import tech.espublico.swspring.entity.PersonJson;
import tech.espublico.swspring.entity.StarshipJson;
import tech.espublico.swspring.entity.SwlistJson;

@Repository("swapiRestRepository")
public class SwapiRestRepository {
  private static final Log LOG = LogFactory.getLog(SwapiRestRepository.class);

  private static final String USER_AGENT =
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
          + "(KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
  private static final String URL_SWAPI = "https://swapi.co/api/";

  private HttpEntity<String> entity;

  /**
   * Default constructor.
   * 
   */
  public SwapiRestRepository() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent", USER_AGENT);
    entity = new HttpEntity<String>("parameters", headers);
  }

  /**
   * Get the list of films from the API.
   * 
   * @return List of FilmJson films
   */
  public List<FilmJson> getFilmsJson() {
    // Template for REST request
    RestTemplate restTemplate = new RestTemplate();
    ArrayList<FilmJson> filmsJson = new ArrayList<FilmJson>();

    ResponseEntity<SwlistJson<FilmJson>> responseFilms;
    String url = URL_SWAPI + "films?format=json";
    while (url != null && url.length() > 0) {
      // Getting next URL REST page
      responseFilms = restTemplate.exchange(url, HttpMethod.GET, entity,
          new ParameterizedTypeReference<SwlistJson<FilmJson>>() {});
      filmsJson.addAll(responseFilms.getBody().results);

      url = responseFilms.getBody().next;
      LOG.debug("url=>" + url);
    }
    return filmsJson;
  }

  /**
   * Return the person information related with this url from de API.
   * 
   * @param url Url to get the person
   * @return PersonJson
   */
  public PersonJson getPersonJson(String url) {
    // Template for REST request
    RestTemplate restTemplate = new RestTemplate();

    return ((ResponseEntity<PersonJson>) restTemplate.exchange(url + "?format=json", HttpMethod.GET,
        entity, PersonJson.class)).getBody();
  }

  /**
   * Return the startship information related with this url from de API.
   * 
   * @param url Url to get the starship
   * @return PersonJson
   */
  public StarshipJson getStarshipJson(String url) {
    // Template for REST request
    RestTemplate restTemplate = new RestTemplate();

    return ((ResponseEntity<StarshipJson>) restTemplate.exchange(url + "?format=json",
        HttpMethod.GET, entity, StarshipJson.class)).getBody();
  }
}
