package tech.espublico.swspring.entity;

/**
 * Entity for STARSHIP table at DB
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
@Table(name = "STARSHIP",
    indexes = {@Index(name = "index_name", columnList = "name", unique = true)})
public class Starship {

  @Id
  private String name;

  private String model;

  @Column(name = "starship_class")
  private String starchipClass;

  private String manufacturer;

  @Column(name = "cost_in_credits")
  private String costInCredits;

  private String length;

  private String crew;

  private String passengers;

  @Column(name = "max_atmosphering_speed")
  private String maxAtmospheringSpeed;

  @Column(name = "hiperdrive_rating")
  private String hiperdriveRating;

  private String mglt;

  @Column(name = "cargo_capacity")
  private String cargoCapacity;

  private String consumables;

  private String url;

  private Date created;

  private Date edited;

  @ManyToMany(mappedBy = "starships")
  private Set<Film> films = new HashSet<Film>();


  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "starship_pilots", joinColumns = {@JoinColumn(name = "id_starship")},
      inverseJoinColumns = {@JoinColumn(name = "id_person")})
  private Set<Person> pilots = new HashSet<Person>();

  public Starship() {

  }

  /**
   * Constructor to parse StarshipJson object to Starship.
   * 
   * @param starshipJson Starship object.
   */
  public Starship(StarshipJson starshipJson) {
    this.name = starshipJson.getName();
    this.model = starshipJson.getModel();
    this.starchipClass = starshipJson.getStarchipClass();
    this.manufacturer = starshipJson.getManufacturer();
    this.costInCredits = starshipJson.getCostInCredits();
    this.length = starshipJson.getLength();
    this.crew = starshipJson.getCrew();
    this.passengers = starshipJson.getPassengers();
    this.maxAtmospheringSpeed = starshipJson.getMaxAtmospheringSpeed();
    this.hiperdriveRating = starshipJson.getHiperdriveRating();
    this.mglt = starshipJson.getMglt();
    this.cargoCapacity = starshipJson.getCargoCapacity();
    this.consumables = starshipJson.getConsumables();
    this.url = starshipJson.getUrl();
    this.created = starshipJson.getCreated();
    this.edited = starshipJson.getEdited();
  }

  /**
   * Add a person to the pilots HashSet.
   * 
   * @param person Pilot to add
   */
  public void addPilot(Person person) {
    if (pilots.contains(person)) {
      return;
    }
    pilots.add(person);
  }

  public Set<Person> getPilots() {
    return pilots;
  }


  public void setPilots(Set<Person> pilots) {
    this.pilots = pilots;
  }


  public Set<Film> getFilms() {
    return films;
  }



  public void setFilms(Set<Film> films) {
    this.films = films;
  }



  public String getUrl() {
    return url;
  }



  public void setUrl(String url) {
    this.url = url;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getStarchipClass() {
    return starchipClass;
  }

  public void setStarchipClass(String starchipClass) {
    this.starchipClass = starchipClass;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getCostInCredits() {
    return costInCredits;
  }

  public void setCostInCredits(String costInCredits) {
    this.costInCredits = costInCredits;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public String getCrew() {
    return crew;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public String getPassengers() {
    return passengers;
  }

  public void setPassengers(String passengers) {
    this.passengers = passengers;
  }

  public String getMaxAtmospheringSpeed() {
    return maxAtmospheringSpeed;
  }

  public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
    this.maxAtmospheringSpeed = maxAtmospheringSpeed;
  }

  public String getHiperdriveRating() {
    return hiperdriveRating;
  }

  public void setHiperdriveRating(String hiperdriveRating) {
    this.hiperdriveRating = hiperdriveRating;
  }

  public String getMglt() {
    return mglt;
  }

  public void setMglt(String mglt) {
    this.mglt = mglt;
  }

  public String getCargoCapacity() {
    return cargoCapacity;
  }

  public void setCargoCapacity(String cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
  }

  public String getConsumables() {
    return consumables;
  }

  public void setConsumables(String consumables) {
    this.consumables = consumables;
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
    return "Starship [name=" + name + ", model=" + model + ", starchipClass=" + starchipClass
        + ", manufacturer=" + manufacturer + ", costInCredits=" + costInCredits + ", length="
        + length + ", crew=" + crew + ", passengers=" + passengers + ", maxAtmospheringSpeed="
        + maxAtmospheringSpeed + ", hiperdriveRating=" + hiperdriveRating + ", mglt=" + mglt
        + ", cargoCapacity=" + cargoCapacity + ", consumables=" + consumables + ", created="
        + created + ", edited=" + edited + "]";
  }

}
