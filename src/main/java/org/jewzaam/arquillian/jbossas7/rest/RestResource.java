package org.jewzaam.arquillian.jbossas7.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces("text/html")
public class RestResource {

    @GET
    @Path("/test")
    public String test() {
        return "<body>HI!</body>";
    }
}