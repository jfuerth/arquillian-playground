package ca.fuerth.tmp;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.fuerth.tmp.beans.Farmer;

@RunWith(Arquillian.class)
public class NamedBeanTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(Farmer.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject BeanManager bm;

    @Test
    public void findFarmerByName() {
      Set<Bean<?>> beans = bm.getBeans("farmer");
//      System.out.println(beans);
      assertEquals(1, beans.size());
    }

    @Test
    public void findFarmerByType() {
      Set<Bean<?>> beans = bm.getBeans(Farmer.class);
      System.out.println(beans);
      assertEquals(1, beans.size());
      assertEquals("farmer", beans.iterator().next().getName());
    }

}