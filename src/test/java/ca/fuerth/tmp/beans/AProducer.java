package ca.fuerth.tmp.beans;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class AProducer {

  @Produces @Named("produced")
  public A produceAnA() {
    return new A() { };
  }
}
