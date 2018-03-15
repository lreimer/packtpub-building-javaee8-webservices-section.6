package com.packtpub.javaee8.jwt;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/jwt")
public class AuthenticationResource {

    @GET
    @Path("/authenticate")
    public Response authenticate() {
        return Response.noContent().build();
    }
}
