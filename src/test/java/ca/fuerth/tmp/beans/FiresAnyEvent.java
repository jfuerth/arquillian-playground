package ca.fuerth.tmp.beans;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * A class that can fire any type of event.
 *
 * @param <E> the type of event to fire
 */
public class FiresAnyEvent<E> {

  @Inject Event<E> eventSource;

  public void fire(E event) {
    eventSource.fire(event);
  }
}
