package tech.espublico.swspring.entity;

/**
 * Class for STARSHIP JSON from API
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class StarshipJson {
  private String name;

  private String model;

  @JsonProperty("starship_class")
  private String starchipClass;

  private String manufacturer;

  @JsonProperty("cost_in_credits")
  private String costInCredits;

  private String length;

  private String crew;

  private String passengers;

  @JsonProperty("max_atmosphering_speed")
  private String maxAtmospheringSpeed;

  @JsonProperty("hiperdrive_rating")
  private String hiperdriveRating;

  private String mglt;

  @JsonProperty("cargo_capacity")
  private String cargoCapacity;

  private String consumables;

  private String url;

  private Date created;

  private Date edited;

  private String[] pilots;


  public StarshipJson() {

  }

  public String[] getPilots() {
    return pilots;
  }

  public void setPilots(String[] pilots) {
    this.pilots = pilots;
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
