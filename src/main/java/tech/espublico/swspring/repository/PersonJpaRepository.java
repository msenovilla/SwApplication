package tech.espublico.swspring.repository;
/**
 * Repository for PERSON table
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.espublico.swspring.entity.Person;

@Repository("personJpaRepository")
public interface PersonJpaRepository extends JpaRepository<Person, Serializable> {
  public Person findByName(String name);

  public List<Person> findAllByOrderByNameAsc();
}
