package tech.espublico.swspring.entity;
/**
 * Class for FILM JSON from API
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class FilmJson {

  private String title;

  @JsonProperty("episode_id")
  private String episodeId;

  @JsonProperty("openning_grawl")
  private String openningGrawl;

  private String director;

  private String producer;

  @JsonProperty("release_date")
  private String releaseDate;

  private String[] characters;

  private String[] starships;

  private String url;

  private Date created;

  private Date edited;


  public FilmJson() {

  }



  public String[] getStarships() {
    return starships;
  }



  public void setStarships(String[] starships) {
    this.starships = starships;
  }



  public String[] getCharacters() {
    return characters;
  }



  public void setCharacters(String[] characters) {
    this.characters = characters;
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
