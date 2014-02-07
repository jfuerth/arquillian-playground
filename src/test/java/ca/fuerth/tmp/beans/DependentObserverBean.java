package ca.fuerth.tmp.beans;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Dependent
public class DependentObserverBean {

  private static final AtomicInteger serialNumber = new AtomicInteger();

  @Inject ApplicationScopedBean appScopedBean;

  private int mySerialNumber;

  @PostConstruct
  private void init() {
    mySerialNumber = serialNumber.incrementAndGet();
  }

  public void lightningRod(@Observes LightningStrike lightning) {
    System.out.println(this + " got " + lightning);
    System.out.println("I see " + appScopedBean);
  }

  @Override
  public String toString() {
    return "DepdenentObserverBean " + mySerialNumber;
  }
}
