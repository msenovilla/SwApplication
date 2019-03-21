package tech.espublico.swspring.controller;
/**
 * Main controller of SwSpring web application
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tech.espublico.swspring.controller.form.CountFilmsForm;
import tech.espublico.swspring.entity.TopPilot;
import tech.espublico.swspring.service.FilmService;
import tech.espublico.swspring.service.PersonService;

@Controller
public class SwSpringController {
  private static final Log LOG = LogFactory.getLog(SwSpringController.class);
  private static final String LIST_PEOPLE_VIEW = "listPeople";
  private static final String LIST_FILMS_VIEW = "listFilms";
  private static final String COUNT_VIEW = "topPilot";

  @Autowired
  @Qualifier("personService")
  PersonService personService;

  @Autowired
  @Qualifier("filmService")
  FilmService filmService;

  /**
   * Redirect to list people page.
   * 
   * @return
   */
  @GetMapping("/listPeople")
  public ModelAndView listPeople() {
    LOG.debug("listPeople");
    ModelAndView mav = new ModelAndView(LIST_PEOPLE_VIEW);
    mav.addObject("people", personService.getPeople());
    return mav;
  }

  /**
   * Redirect to list films page.
   * 
   * @return
   */
  @GetMapping("/listFilms")
  public ModelAndView listFilms() {
    LOG.debug("listFilms");
    ModelAndView mav = new ModelAndView(LIST_FILMS_VIEW);
    mav.addObject("films", filmService.getFilms());
    mav.addObject("top", new TopPilot());
    return mav;
  }

  /**
   * Redirect to top pilot of these films page.
   * 
   * @param films List of films selected
   * @return
   */
  @PostMapping("/getCountFilms")
  public ModelAndView getCountFilms(@ModelAttribute("films") CountFilmsForm films) {
    LOG.debug("getCountFilms");
    ModelAndView mav = new ModelAndView();

    if (films != null && films.getFilms() != null && films.getFilms().size() > 0) {
      TopPilot top = filmService.getTopPilotByFilms(films.getFilms());
      mav.addObject("top", top);
      mav.addObject("films", films.getFilms());
      mav.setViewName(COUNT_VIEW);
    } else {
      mav.addObject("films", filmService.getFilms());
      mav.addObject("top", new TopPilot());
      mav.setViewName(LIST_FILMS_VIEW);
    }
    return mav;
  }
}
