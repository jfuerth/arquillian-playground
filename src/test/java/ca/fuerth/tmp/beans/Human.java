package ca.fuerth.tmp.beans;

import javax.enterprise.context.Dependent;

/**
 * @author Mike Brock
 */
@Dependent
public class Human {
  public String getClassName() {
      return Human.class.getName();
  }
}
