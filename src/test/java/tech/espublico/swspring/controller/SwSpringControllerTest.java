package tech.espublico.swspring.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils;
import tech.espublico.swspring.controller.form.CountFilmsForm;
import tech.espublico.swspring.entity.Film;
import tech.espublico.swspring.entity.Person;
import tech.espublico.swspring.entity.TopPilot;
import tech.espublico.swspring.service.FilmService;
import tech.espublico.swspring.service.PersonService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SwSpringControllerTest {

  @InjectMocks
  private SwSpringController swSpringController;

  @Autowired
  private MockMvc mvc;

  @Mock
  private PersonService personService;

  @Mock
  private FilmService filmService;

  /**
   * Before test cases method.
   * 
   */
  @Before
  public void init() {
    mvc = MockMvcBuilders.standaloneSetup(swSpringController).setViewResolvers(viewResolver())
        .build();
  }

  private ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

    viewResolver.setPrefix("classpath:templates/");
    viewResolver.setSuffix(".html");

    return viewResolver;
  }

  @Test
  public void listpeopleTest() throws Exception {
    // Mock data
    ArrayList<Person> peopleMock = new ArrayList<Person>();
    Person personMock1 = new Person();
    personMock1.setName("PersonTest1");
    Person personMock2 = new Person();
    personMock1.setName("PersonTest2");
    peopleMock.add(personMock1);
    peopleMock.add(personMock2);

    when(personService.getPeople()).thenReturn(peopleMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/listPeople");

    MvcResult resultRequest = mvc.perform(requestBuilder).andReturn();
    assertEquals(
        ((ArrayList<Person>) resultRequest.getModelAndView().getModel().get("people")).size(), 2);

  }

  @Test
  public void listfilmsTest() throws Exception {
    // Mock data
    ArrayList<Film> filmsMock = new ArrayList<Film>();
    Film filmMock1 = new Film();
    filmMock1.setTitle("FilmTest1");
    Film filmMock2 = new Film();
    filmMock2.setTitle("FilmTest2");
    filmsMock.add(filmMock2);
    filmsMock.add(filmMock2);

    when(filmService.getFilms()).thenReturn(filmsMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/listFilms");

    MvcResult resultRequest = mvc.perform(requestBuilder).andReturn();
    assertEquals(
        ((ArrayList<Person>) resultRequest.getModelAndView().getModel().get("films")).size(), 2);

  }

  @Test
  public void getCountfilmsokTest() throws Exception {
    // Mock data
    ArrayList<Film> filmsMock = new ArrayList<Film>();
    Film filmMock1 = new Film();
    filmMock1.setTitle("FilmTest1");
    Film filmMock2 = new Film();
    filmMock2.setTitle("FilmTest2");
    filmsMock.add(filmMock2);
    filmsMock.add(filmMock2);

    ArrayList<String> filmsNames = new ArrayList<String>();
    filmsNames.add("testFilm1");
    filmsNames.add("testFilm2");

    CountFilmsForm countMock = new CountFilmsForm();
    countMock.setFilms(filmsNames);

    TopPilot topMock = new TopPilot("PilotTest", 5);

    when(filmService.getTopPilotByFilms(filmsNames)).thenReturn(topMock);


    MvcResult resultRequest =
        mvc.perform(MockMvcRequestBuilderUtils.postForm("/getCountFilms", countMock)).andReturn();
    TopPilot topResult = (TopPilot) resultRequest.getModelAndView().getModel().get("top");
    assertEquals(topResult.getName(), topMock.getName());
    assertEquals(topResult.getCount(), topMock.getCount());
    assertEquals(((ArrayList<Film>) resultRequest.getModelAndView().getModel().get("films")).size(),
        2);

  }
  
  @Test
  public void getCountfilmskoTest() throws Exception {
    // Mock data
    ArrayList<Film> filmsMock = new ArrayList<Film>();
    Film filmMock1 = new Film();
    filmMock1.setTitle("FilmTest1");
    Film filmMock2 = new Film();
    filmMock2.setTitle("FilmTest2");
    filmsMock.add(filmMock2);
    filmsMock.add(filmMock2);

    ArrayList<String> filmsNames = new ArrayList<String>();
    filmsNames.add("testFilm1");
    filmsNames.add("testFilm2");

    CountFilmsForm countMock = new CountFilmsForm();

    TopPilot topMock = new TopPilot("PilotTest", 5);

    when(filmService.getTopPilotByFilms(filmsNames)).thenReturn(topMock);
    when(filmService.getFilms()).thenReturn(filmsMock);


    MvcResult resultRequest = mvc.perform(MockMvcRequestBuilderUtils.postForm("/getCountFilms", countMock)).andReturn();
    TopPilot topResult = (TopPilot) resultRequest.getModelAndView().getModel().get("top");
    assertEquals(topResult.getName(),"");
    assertEquals(topResult.getCount(),0);
    assertEquals(((ArrayList<Film>) resultRequest.getModelAndView().getModel().get("films")).size(),
        2);

  }


}
