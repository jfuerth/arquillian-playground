package ca.fuerth.tmp.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class ApplicationScopedBean {

  @Inject private DependentObserverBean observerBean;
  @Inject private DependentObserverBean observerBean2;
  @Inject private DependentObserverBean observerBean3;
  @Inject private DependentObserverBean observerBean4;

  public DependentObserverBean getObserverBean() {
    return observerBean;
  }

  public void lightningRod(@Observes LightningStrike lightning) {
    System.out.println(this + " got " + lightning);
  }
}
