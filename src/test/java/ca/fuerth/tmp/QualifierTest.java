package ca.fuerth.tmp;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.fuerth.tmp.beans.A;
import ca.fuerth.tmp.beans.B;

@RunWith(Arquillian.class)
public class QualifierTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackage(A.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject BeanManager bm;
    @Inject @Named("produced") A a;

    @Test
    public void checkWhatAIs() {
      System.out.println(a.getClass());
    }

}