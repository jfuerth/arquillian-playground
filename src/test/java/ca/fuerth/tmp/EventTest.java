package ca.fuerth.tmp;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.fuerth.tmp.beans.ApplicationScopedBean;
import ca.fuerth.tmp.beans.LightningStrike;


@RunWith(Arquillian.class)
public class EventTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(LightningStrike.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject Event<LightningStrike> lightningEvent;
    @Inject ApplicationScopedBean appScopedBean;

    @Test
    public void testLightning() throws Exception {
      System.out.println("AppScopedBean has " + appScopedBean.getObserverBean());
      lightningEvent.fire(new LightningStrike(10));
      lightningEvent.fire(new LightningStrike(20));
    }
}
