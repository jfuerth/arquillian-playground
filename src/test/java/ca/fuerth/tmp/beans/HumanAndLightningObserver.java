package ca.fuerth.tmp.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class HumanAndLightningObserver {

  private LightningStrike observedLightningStrike;
  private Human observedHuman;

  private void observeLightningStrike(@Observes LightningStrike ls) {
    this.observedLightningStrike = ls;
  }

  private void observeHuman(@Observes Human h) {
    this.observedHuman = h;
  }

  public LightningStrike getObservedLightningStrike() {
    return observedLightningStrike;
  }

  public Human getObservedHuman() {
    return observedHuman;
  }

  public void clear() {
    observedLightningStrike = null;
    observedHuman = null;
  }
}
