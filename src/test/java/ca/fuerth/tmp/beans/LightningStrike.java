package ca.fuerth.tmp.beans;

/**
 * An event for firing to CDI observers.
 *
 * @author Jonathan Fuerth <jfuerth@redhat.com>
 */
public class LightningStrike {

  private final int id;

  public LightningStrike(int id) {
    super();
    this.id = id;
  }

  @Override
  public String toString() {
    return "LightningStrike [id=" + id + "]";
  }

}
