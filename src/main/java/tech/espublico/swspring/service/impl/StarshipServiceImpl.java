package tech.espublico.swspring.service.impl;
/**
 * Service implementation for STARSHIP table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tech.espublico.swspring.entity.Starship;
import tech.espublico.swspring.entity.StarshipJson;
import tech.espublico.swspring.repository.StarshipJpaRepository;
import tech.espublico.swspring.repository.SwapiRestRepository;
import tech.espublico.swspring.service.StarshipService;

@Service("starshipService")
public class StarshipServiceImpl implements StarshipService {
  private static final Log LOG = LogFactory.getLog(StarshipServiceImpl.class);

  @Autowired
  @Qualifier("starshipJpaRepository")
  private StarshipJpaRepository starshipJpaRepository;
  

  @Autowired
  @Qualifier("swapiRestRepository")
  private SwapiRestRepository swapiRestRepository;


  @Override
  public List<StarshipJson> getStarshipsJson() {
    LOG.debug(" -- getStarshipsJSON ");
    return swapiRestRepository.getStarshipsJson();
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
