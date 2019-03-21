package tech.espublico.swspring.entity;

/**
 * Class for store results of Top Pilot Query.
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */

public class TopPilot {
  private long count;
  private String name;

  public TopPilot() {
    count = 0;
    name = "";
  }

  /**
   * Constructor with fields.
   * 
   * @param name Name of pilot
   * @param count Number of films
   */
  public TopPilot(String name, long count) {
    super();
    this.count = count;
    this.name = name;
  }


  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
