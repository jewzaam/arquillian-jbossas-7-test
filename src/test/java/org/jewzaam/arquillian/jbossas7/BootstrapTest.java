package org.jewzaam.arquillian.jbossas7;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Arquillian.class)
public class BootstrapTest {
    @Deployment
    public static WebArchive createTestArchive() {
        // create archive
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsResource(new File("src/main/webapp/index.html"))
                .addAsResource(new File("src/main/webapp/health.jsp"))
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/jboss-web.xml"))
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/web.xml"))
                ;

        return archive;
    }

    @Test
    public void emptyTest() {
        // yay, success.
        String s;// for a breakpoint
    }
}
