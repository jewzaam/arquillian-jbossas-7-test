package org.jewzaam.arquillian.jbossas7;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jewzaam.arquillian.jbossas7.rest.RestResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Arquillian.class)
public class BootstrapTest {

    @Deployment
    public static WebArchive createTestArchive() {
//        File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile();

        // create archive
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(new File("src/main/webapp/index.html"))
                .addAsResource(new File("src/main/webapp/health.jsp"))
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/jboss-web.xml"));

//        for (File file : libs) {
//            archive.addAsLibrary(file);
//        }

        archive.addPackages(true, "org.jewzaam.arquillian.jbossas7.rest");

        return archive;
    }

    @Inject
    private RestResource restResource;

    @Test
    public void emptyTest() {
        Assert.assertNotNull(restResource);
        // yay, success.
        String s = "";// for a breakpoint
        s += "nmalik";
    }
}
