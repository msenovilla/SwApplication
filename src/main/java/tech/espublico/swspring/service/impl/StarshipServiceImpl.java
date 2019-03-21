package tech.espublico.swspring.service.impl;
/**
 * Service implementation for STARSHIP table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.espublico.swspring.entity.Starship;
import tech.espublico.swspring.entity.SwlistJson;
import tech.espublico.swspring.repository.StarshipJpaRepository;
import tech.espublico.swspring.service.StarshipService;

@Service("starshipService")
public class StarshipServiceImpl implements StarshipService {
  private static final Log LOG = LogFactory.getLog(StarshipServiceImpl.class);
  private static final String USER_AGENT =
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
          + "(KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
  private static final String URL_SWAPI = "https://swapi.co/api/";

  private HttpEntity<String> entity;

  @Autowired
  @Qualifier("starshipJpaRepository")
  private StarshipJpaRepository starshipJpaRepository;

  /**
   * Default constructor, where HttpEntity is established.
   */
  public StarshipServiceImpl() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent", USER_AGENT);
    entity = new HttpEntity<String>("parameters", headers);
  }

  @Override
  public List<Starship> getStarshipsJson() {
    LOG.debug(" -- getStarshipsJSON ");
    RestTemplate restTemplate = new RestTemplate();
    ArrayList<Starship> starships = new ArrayList<Starship>();

    ResponseEntity<SwlistJson<Starship>> responseStarships;
    String url = URL_SWAPI + "starships?format=json";
    while (url != null && url.length() > 0) {
      responseStarships = restTemplate.exchange(url, HttpMethod.GET, entity,
          new ParameterizedTypeReference<SwlistJson<Starship>>() {});
      // Getting next URL REST page
      starships.addAll(responseStarships.getBody().results);
      url = responseStarships.getBody().next;
      LOG.debug("url=>" + url);
    }

    return starships;
  }

  @Override
  public void insertStarships(List<Starship> starships) {
    starshipJpaRepository.saveAll(starships);
  }

  @Override
  public void deleteAllStarship() {
    starshipJpaRepository.deleteAll();

  }
}
