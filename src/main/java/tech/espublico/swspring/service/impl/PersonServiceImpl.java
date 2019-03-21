package tech.espublico.swspring.service.impl;
/**
 * Service Implementation for PERSON table
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
import tech.espublico.swspring.entity.Person;
import tech.espublico.swspring.entity.PersonJson;
import tech.espublico.swspring.entity.SwlistJson;
import tech.espublico.swspring.repository.PersonJpaRepository;
import tech.espublico.swspring.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
  private static final Log LOG = LogFactory.getLog(PersonServiceImpl.class);
  private static final String USER_AGENT =
      "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
          + "(KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
  private static final String URL_SWAPI = "https://swapi.co/api/";

  private HttpEntity<String> entity;

  @Autowired
  @Qualifier("personJpaRepository")
  private PersonJpaRepository personJpaRepository;

  /**
   * Default constructor, where HttpEntity is established.
   */
  public PersonServiceImpl() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent", USER_AGENT);
    entity = new HttpEntity<String>("parameters", headers);
  }

  @Override
  public List<PersonJson> getPeopleJson() throws IllegalStateException {
    LOG.debug(" -- getPeopleJSON ");
    RestTemplate restTemplate = new RestTemplate();
    ArrayList<PersonJson> peopleJson = new ArrayList<PersonJson>();

    ResponseEntity<SwlistJson<PersonJson>> responseFilms;
    String url = URL_SWAPI + "people?format=json";
    while (url != null && url.length() > 0) {
      responseFilms = restTemplate.exchange(url, HttpMethod.GET, entity,
          new ParameterizedTypeReference<SwlistJson<PersonJson>>() {});
      // Getting next URL REST page
      peopleJson.addAll(responseFilms.getBody().results);
      url = responseFilms.getBody().next;
      LOG.debug("url=>" + url);
    }
    return peopleJson;
  }

  @Override
  public void deleteAllPeople() {
    personJpaRepository.deleteAll();

  }

  @Override
  public List<Person> getPeople() {
    return personJpaRepository.findAllByOrderByNameAsc();
  }

  @Override
  public void insertPeople(List<PersonJson> people) {
    LOG.debug(" -- insertPeople ");
    ArrayList<PersonJson> peopleJsonlist = (ArrayList<PersonJson>) people;

    for (int i = 0; i < peopleJsonlist.size(); i++) {
      LOG.debug("### Person=>" + peopleJsonlist.get(i).getName());
      personJpaRepository.save(new Person(peopleJsonlist.get(i)));
    }

  }
}
