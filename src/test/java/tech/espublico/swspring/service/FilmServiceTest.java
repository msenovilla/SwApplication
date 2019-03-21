package tech.espublico.swspring.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tech.espublico.swspring.entity.Film;
import tech.espublico.swspring.entity.FilmJson;
import tech.espublico.swspring.entity.Person;
import tech.espublico.swspring.entity.PersonJson;
import tech.espublico.swspring.entity.Starship;
import tech.espublico.swspring.entity.StarshipJson;
import tech.espublico.swspring.entity.TopPilot;
import tech.espublico.swspring.repository.FilmJpaRepository;
import tech.espublico.swspring.repository.SwapiRestRepository;
import tech.espublico.swspring.service.impl.FilmServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class FilmServiceTest {
  @Mock
  FilmJpaRepository filmRepositoryMock;

  @Mock
  SwapiRestRepository swapiRepositoryMock;

  @InjectMocks
  FilmServiceImpl filmService;

  @Test
  public void getFilmsTest() {
    // Mock data
    ArrayList<Film> filmsMock = new ArrayList<Film>();
    Film firstFilm = new Film();
    firstFilm.setTitle("A New Hope");
    filmsMock.add(firstFilm);

    when(filmRepositoryMock.findAllByOrderByTitleAsc()).thenReturn(filmsMock);

    assertThat(filmService.getFilms().size(), is(1));
  }

  @Test
  public void insertFilmsTest() {
    // Mock data
    ArrayList<TopPilot> topPilotArray = new ArrayList<TopPilot>();
    topPilotArray.add(new TopPilot("Test1", 100));

    when(filmRepositoryMock.getTopPilotByFilms(Arrays.asList(new String[] {"A New Hope"})))
        .thenReturn(topPilotArray);

    assertEquals(
        filmService.getTopPilotByFilms(Arrays.asList(new String[] {"A New Hope"})).getName(),
        "Test1");
  }

  @Test
  public void getFilmsjsonTest() {
    // Mock data
    ArrayList<FilmJson> filmsMock = new ArrayList<FilmJson>();
    FilmJson firstFilm = new FilmJson();
    firstFilm.setTitle("A New Hope");
    filmsMock.add(firstFilm);

    when(swapiRepositoryMock.getFilmsJson()).thenReturn(filmsMock);

    List<FilmJson> resultFilms = filmService.getFilmsJson();
    assertThat(resultFilms.size(), is(1));
  }

  @Test
  public void insertfilmsTest() {
    // Mock data
    PersonJson personMock = new PersonJson();
    personMock.setName("PersonTest");
    StarshipJson startshipMock = new StarshipJson();
    startshipMock.setName("StarshipTest");
    startshipMock.setPilots(new String[] {"testURLPilot"});
    PersonJson pilotMock = new PersonJson();
    pilotMock.setName("PilotTest");

    ArrayList<FilmJson> filmsjsonMock = new ArrayList<FilmJson>();
    FilmJson filmMock = new FilmJson();
    filmMock.setCharacters(new String[] {"testURLPerson"});
    filmMock.setStarships(new String[] {"testURLStarship"});
    filmsjsonMock.add(filmMock);

    Film filmInsertMock = new Film();
    filmInsertMock.addCharacter(new Person(personMock));
    Starship starshipInsertMock = new Starship();
    starshipInsertMock.addPilot(new Person(pilotMock));
    filmInsertMock.addStarship(starshipInsertMock);
    ArrayList<Film> listFilminsertMock = new ArrayList<Film>();
    listFilminsertMock.add(filmInsertMock);


    when(swapiRepositoryMock.getPersonJson("testURLPerson")).thenReturn(personMock);
    when(swapiRepositoryMock.getStarshipJson("testURLStarship")).thenReturn(startshipMock);
    when(swapiRepositoryMock.getPersonJson("testURLPilot")).thenReturn(pilotMock);
    when(filmRepositoryMock.save(filmInsertMock)).thenReturn(filmInsertMock);

    assertEquals(filmService.insertFilms(filmsjsonMock).size(), 1);
  }

  @Test
  public void getToppilotTest() {
    // filmJpaRepository.getTopPilotByFilms(films)
    ArrayList<String> filmsMock = new ArrayList<String>();
    filmsMock.add("TestFilm");
    TopPilot toppilotMock = new TopPilot("PilotTest", 5);
    ArrayList<TopPilot> listtoppilotMock = new ArrayList<TopPilot>();
    listtoppilotMock.add(toppilotMock);


    when(filmRepositoryMock.getTopPilotByFilms(filmsMock)).thenReturn(listtoppilotMock);

    TopPilot toppilotResult = filmService.getTopPilotByFilms(filmsMock);
    assertEquals(toppilotResult.getName(), "PilotTest");
    assertEquals(toppilotResult.getCount(), 5);
  }

}
