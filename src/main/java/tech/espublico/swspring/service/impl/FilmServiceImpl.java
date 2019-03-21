package tech.espublico.swspring.service.impl;

/**
 * Service implementation for FILM table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.espublico.swspring.entity.Film;
import tech.espublico.swspring.entity.FilmJson;
import tech.espublico.swspring.entity.Person;
import tech.espublico.swspring.entity.PersonJson;
import tech.espublico.swspring.entity.Starship;
import tech.espublico.swspring.entity.StarshipJson;
import tech.espublico.swspring.entity.TopPilot;
import tech.espublico.swspring.repository.FilmJpaRepository;
import tech.espublico.swspring.repository.SwapiRestRepository;
import tech.espublico.swspring.service.FilmService;

@Service("filmService")
public class FilmServiceImpl implements FilmService {
  private static final Log LOG = LogFactory.getLog(FilmServiceImpl.class);

  @Autowired
  @Qualifier("filmJpaRepository")
  private FilmJpaRepository filmJpaRepository;

  @Autowired
  @Qualifier("swapiRestRepository")
  private SwapiRestRepository swapiRestRepository;


  @Override
  public List<FilmJson> getFilmsJson() {
    return swapiRestRepository.getFilmsJson();
  }

  @Override
  public List<Film> insertFilms(List<FilmJson> filmsJson) {
    ArrayList<FilmJson> filmsJsonList = (ArrayList<FilmJson>) filmsJson;
    ArrayList<Film> filmsInserted = new ArrayList<Film>();
    String[] characters;
    String[] starships;
    String[] pilots;
    Film filmToInsert;
    PersonJson personJson;
    StarshipJson starshipJson;
    Starship starship;
    PersonJson pilotJson;
    String url;

    for (int i = 0; i < filmsJsonList.size(); i++) {
      filmToInsert = new Film(filmsJsonList.get(i));
      characters = filmsJsonList.get(i).getCharacters();
      starships = filmsJsonList.get(i).getStarships();

      // Getting all characters information

      for (int j = 0; j < characters.length; j++) {
        url = characters[j];
        personJson = swapiRestRepository.getPersonJson(url);
        filmToInsert.addCharacter(new Person(personJson));
      }

      // Getting all starships information
      for (int j = 0; j < starships.length; j++) {
        url = starships[j];
        starshipJson = swapiRestRepository.getStarshipJson(url);
        starship = new Starship(starshipJson);
        LOG.debug("### Startship=>" + starship.getName());

        // Getting all pilots of this starship information
        pilots = starshipJson.getPilots();
        for (int k = 0; k < pilots.length; k++) {
          url = pilots[k];
          pilotJson = swapiRestRepository.getPersonJson(url);
          LOG.debug("###### Pilot of starship=>" + pilotJson.getName());
          starship.addPilot(new Person(pilotJson));
        }

        filmToInsert.addStarship(starship);
      }
      filmsInserted.add(filmJpaRepository.save(filmToInsert));
    }
    return filmsInserted;
  }

  @Override
  public void deleteAllFilms() {
    filmJpaRepository.deleteAll();
  }

  @Override
  public List<Film> getFilms() {
    return filmJpaRepository.findAllByOrderByTitleAsc();
  }

  @Override
  public TopPilot getTopPilotByFilms(List<String> films) {
    List<TopPilot> listTop = filmJpaRepository.getTopPilotByFilms(films);
    return listTop.get(0);
  }
}
