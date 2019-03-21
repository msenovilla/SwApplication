package tech.espublico.swspring.entity;

/**
 * Class for PERSON JSON from API
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class PersonJson {

  private String name;

  @JsonProperty("birth_year")
  private String birthYear;

  @JsonProperty("eye_color")
  private String eyeColor;

  private String gender;

  @JsonProperty("hair_color")
  private String hairColor;

  private String height;

  private String mass;

  @JsonProperty("skin_color")
  private String skinColor;

  private String homeworld;

  private String url;

  private Date created;

  private Date edited;

  private String[] films;

  public PersonJson() {

  }

  public String[] getFilms() {
    return films;
  }


  public void setFilms(String[] films) {
    this.films = films;
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
