package tech.espublico.swspring.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.espublico.swspring.entity.FilmJson;
import tech.espublico.swspring.entity.PersonJson;
import tech.espublico.swspring.service.FilmService;
import tech.espublico.swspring.service.PersonService;
import tech.espublico.swspring.service.StarshipService;

@Component
public class InitBd implements CommandLineRunner {

  private static final Log LOG = LogFactory.getLog(InitBd.class);

  @Autowired
  @Qualifier("filmService")
  FilmService filmService;

  @Autowired
  @Qualifier("personService")
  PersonService personService;

  @Autowired
  @Qualifier("starshipService")
  StarshipService starshipService;

  @Override
  public void run(String... args) throws Exception {
    LOG.debug("### DELETING DATA");


    filmService.deleteAllFilms();
    starshipService.deleteAllStarship();
    personService.deleteAllPeople();

    // Reading films, people and starships from API and inserting them in DB
    LOG.debug("### INSERTING DATA");
    try {
      List<PersonJson> listPeople = personService.getPeopleJson();
      personService.insertPeople(listPeople);

      List<FilmJson> listFilms = filmService.getFilmsJson();
      filmService.insertFilms(listFilms);
    } catch (Exception e) {
      LOG.error("Error inserting data: " + e.getMessage());
      throw e;
    }
  }

}
