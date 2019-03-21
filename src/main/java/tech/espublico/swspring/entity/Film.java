package tech.espublico.swspring.entity;
/**
 * Entity for FILM table at DB
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILM", indexes = {@Index(name = "index_title", columnList = "title", unique = true)})
public class Film {
  @Id
  private String title;

  @Column(name = "episode_id")
  private String episodeId;

  @Column(name = "openning_grawl", length = 2500)
  private String openningGrawl;

  private String director;

  private String producer;

  @Column(name = "release_date")
  private String releaseDate;

  private String url;

  private Date created;

  private Date edited;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "starship_film", joinColumns = {@JoinColumn(name = "id_film")},
      inverseJoinColumns = {@JoinColumn(name = "id_starship")})
  private Set<Starship> starships = new HashSet<Starship>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "character_film", joinColumns = {@JoinColumn(name = "id_film")},
      inverseJoinColumns = {@JoinColumn(name = "id_person")})
  private Set<Person> characters = new HashSet<Person>();

  public Film() {

  }

  /**
   * Constructor to parse FilmJson object to Film.
   * 
   * @param filmJson FilmJson object
   */
  public Film(FilmJson filmJson) {
    this.title = filmJson.getTitle();
    this.episodeId = filmJson.getEpisodeId();
    this.openningGrawl = filmJson.getOpenningGrawl();
    this.director = filmJson.getDirector();
    this.producer = filmJson.getProducer();
    this.releaseDate = filmJson.getReleaseDate();
    this.url = filmJson.getUrl();
    this.created = filmJson.getCreated();
    this.edited = filmJson.getEdited();
  }

  /**
   * Add a character to the person HashSet.
   * 
   * @param person Person to add
   */
  public void addCharacter(Person person) {
    if (characters.contains(person)) {
      return;
    }
    characters.add(person);
  }


  public Set<Person> getCharacters() {
    return characters;
  }

  public void setCharacters(Set<Person> characters) {
    this.characters = characters;
  }

  public Set<Starship> getStarships() {
    return starships;
  }

  public void setStarships(Set<Starship> starships) {
    this.starships = starships;
  }

  /**
   * Add a startship to the startships HashSet.
   * 
   * @param starship Starship to add
   */
  public void addStarship(Starship starship) {
    if (starships.contains(starship)) {
      return;
    }
    starships.add(starship);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getEpisodeId() {
    return episodeId;
  }

  public void setEpisodeId(String episodeId) {
    this.episodeId = episodeId;
  }

  public String getOpenningGrawl() {
    return openningGrawl;
  }

  public void setOpenningGrawl(String openningGrawl) {
    this.openningGrawl = openningGrawl;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
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
    return "Film [title=" + title + ", episodeId=" + episodeId + ", openningGrawl=" + openningGrawl
        + ", director=" + director + ", producer=" + producer + ", releaseDate=" + releaseDate
        + ", url=" + url + ", created=" + created + ", edited=" + edited + "]";
  }



}
