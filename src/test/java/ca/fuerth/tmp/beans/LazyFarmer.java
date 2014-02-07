package ca.fuerth.tmp.beans;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Specializes;


@Dependent
//@Lazy
@Specializes
public class LazyFarmer extends Farmer {
  @Override
  public String getClassName() {
    return LazyFarmer.class.getName();
  }
}