package com.packtpub.javaee8.metrics;


import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

@ApplicationScoped
@Path("healthcheck")
public class HealthcheckResource {

    @Inject
    private HealthCheckRegistry healthCheckRegistry;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response metrics() {
        SortedMap<String, HealthCheck.Result> results = healthCheckRegistry.runHealthChecks();
        if (results.isEmpty()) {
            return Response.status(Response.Status.NOT_IMPLEMENTED).build();
        } else if (isAllHealthy(results)) {
            return Response.ok(results).build();
        } else {
            return Response.serverError().build();
        }
    }

    private static boolean isAllHealthy(Map<String, HealthCheck.Result> results) {
        Iterator health = results.values().iterator();

        HealthCheck.Result result;
        do {
            if (!health.hasNext()) {
                return true;
            }

            result = (HealthCheck.Result) health.next();
        } while (result.isHealthy());

        return false;
    }

}
