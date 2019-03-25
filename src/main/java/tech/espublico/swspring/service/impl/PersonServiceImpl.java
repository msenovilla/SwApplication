package tech.espublico.swspring.service.impl;
/**
 * Service Implementation for PERSON table
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

import tech.espublico.swspring.entity.Person;
import tech.espublico.swspring.entity.PersonJson;
import tech.espublico.swspring.repository.PersonJpaRepository;
import tech.espublico.swspring.repository.SwapiRestRepository;
import tech.espublico.swspring.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	private static final Log LOG = LogFactory.getLog(PersonServiceImpl.class);

	@Autowired
	@Qualifier("personJpaRepository")
	private PersonJpaRepository personJpaRepository;

	@Autowired
	@Qualifier("swapiRestRepository")
	private SwapiRestRepository swapiRestRepository;

	@Override
	public List<PersonJson> getPeopleJson() throws IllegalStateException {
		LOG.debug(" -- getPeopleJSON ");
		return swapiRestRepository.getPeopleJson();
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
