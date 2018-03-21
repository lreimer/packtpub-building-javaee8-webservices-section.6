package com.packtpub.javaee8.metrics;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
@Path("metrics")
public class MetricsResource {

    private Random random = new Random(4711L);

    private AtomicLong poolSize = new AtomicLong(10);

    @POST
    @Path("/timed")
    public Response timed() throws InterruptedException {
        poolSize.incrementAndGet();
        TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
        poolSize.decrementAndGet();

        return Response.noContent().build();
    }

    public long gauge() {
        return poolSize.get();
    }

    @POST
    @Path("/counted")
    public Response counted() throws InterruptedException {
        poolSize.incrementAndGet();
        TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
        poolSize.decrementAndGet();

        return Response.noContent().build();
    }

}
