package ca.fuerth.tmp;

import static org.junit.Assert.assertSame;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.fuerth.tmp.beans.FiresAnyEvent;
import ca.fuerth.tmp.beans.FiresOnlyHumans;
import ca.fuerth.tmp.beans.Human;
import ca.fuerth.tmp.beans.HumanAndLightningObserver;
import ca.fuerth.tmp.beans.LightningStrike;


@RunWith(Arquillian.class)
public class ParameterizedEventInjectionTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(FiresAnyEvent.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject Event<LightningStrike> regularLightningEventSource;
    @Inject FiresAnyEvent<LightningStrike> parameterizedLightningEventSource;
    @Inject FiresOnlyHumans humanEventSource;

    @Inject HumanAndLightningObserver observer;

    @Before
    public void resetObserver() {
      observer.clear();
    }

    @Test
    public void testNormalEventSource() {
      LightningStrike ls = new LightningStrike(1);
      regularLightningEventSource.fire(ls);
      assertSame(ls, observer.getObservedLightningStrike());
    }

    @Test
    public void testTypeParamDefinedAtInjectionPoint() {
      LightningStrike ls = new LightningStrike(1);
      parameterizedLightningEventSource.fire(ls);
      assertSame(ls, observer.getObservedLightningStrike());
    }

    @Test
    public void testTypeParamDefinedBySubclass() {
      Human h = new Human();
      humanEventSource.fire(h);
      assertSame(h, observer.getObservedHuman());
    }

}
