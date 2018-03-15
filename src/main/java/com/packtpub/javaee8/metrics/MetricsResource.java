package com.packtpub.javaee8.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Path("metrics")
public class MetricsResource {

    @Inject
    private MetricRegistry metricRegistry;

    private Random random = new Random(4711L);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response metrics() {
        return Response.ok(metricRegistry.getMetrics()).build();
    }

    @POST
    @Path("/timed")
    @Timed
    public Response timed() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
        return Response.noContent().build();
    }

    @POST
    @Path("/gauge")
    @Gauge
    public Response gauge() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
        return Response.noContent().build();
    }

    @POST
    @Path("/counted")
    @Counted
    public Response counted() {
        return Response.noContent().build();
    }

}
