package tech.espublico.swspring.entity;

/**
 * Class for Main properties in JSON from API
 * 
 * @autor Miriam Senovilla
 * @version 1.0
 */
import java.util.List;

public class SwlistJson<T> {
  public int count;
  public String next;
  public String previous;
  public List<T> results;

  public boolean hasMore() {
    return (next != null && !next.isEmpty());
  }
}
