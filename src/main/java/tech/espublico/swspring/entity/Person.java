package tech.espublico.swspring.entity;

/**
 * Entity for PERSON table at DB
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "PERSON", indexes = {@Index(name = "index_name", columnList = "name", unique = true)})
public class Person {
  @Id
  private String name;

  @Column(name = "birth_year")
  @Nullable
  private String birthYear;

  @Column(name = "eye_color")
  private String eyeColor;

  private String gender;

  @Column(name = "hair_color")
  private String hairColor;

  private String height;

  private String mass;

  @Column(name = "skin_color")
  private String skinColor;

  private String homeworld;

  private String url;

  private Date created;

  private Date edited;


  @ManyToMany(mappedBy = "pilots")
  private Set<Starship> starships = new HashSet<Starship>();

  @ManyToMany(mappedBy = "characters")
  private Set<Film> films = new HashSet<Film>();


  public Person() {

  }

  /**
   * Constructor to parse PersonJson object to Person.
   * 
   * @param personJson PersonJson object
   */
  public Person(PersonJson personJson) {
    this.name = personJson.getName();
    this.birthYear = personJson.getBirthYear();
    this.eyeColor = personJson.getEyeColor();
    this.gender = personJson.getGender();
    this.hairColor = personJson.getHairColor();
    this.height = personJson.getHeight();
    this.mass = personJson.getMass();
    this.skinColor = personJson.getSkinColor();
    this.homeworld = personJson.getHomeworld();
    this.url = personJson.getUrl();
    this.created = personJson.getCreated();
    this.edited = personJson.getEdited();
  }



  public Set<Film> getFilms() {
    return films;
  }

  public void setFilms(Set<Film> films) {
    this.films = films;
  }

  public Set<Starship> getStarships() {
    return starships;
  }

  public void setStarships(Set<Starship> starships) {
    this.starships = starships;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getEyeColor() {
    return eyeColor;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHairColor() {
    return hairColor;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getMass() {
    return mass;
  }

  public void setMass(String mass) {
    this.mass = mass;
  }

  public String getSkinColor() {
    return skinColor;
  }

  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getEdited() {
    return edited;
  }

  public void setEdited(Date edited) {
    this.edited = edited;
  }

  @Override
  public String toString() {
    return "People [name=" + name + ", birthYear=" + birthYear + ", eyeColor=" + eyeColor
        + ", gender=" + gender + ", hairColor=" + hairColor + ", height=" + height + ", mass="
        + mass + ", skinColor=" + skinColor + ", homeworld=" + homeworld + ", url=" + url
        + ", created=" + created + ", edited=" + edited + "]";
  }



}
