package com.packtpub.javaee8.jwt;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/jwt")
public class AuthenticationResource {

    @GET
    @Path("/authenticate")
    public Response authenticate() {
        return Response.noContent().build();
    }
}
