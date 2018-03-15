package com.packtpub.javaee8;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jersey2.InstrumentedResourceMethodApplicationListener;
import com.packtpub.javaee8.metrics.HealthcheckResource;
import com.packtpub.javaee8.metrics.MetricsResource;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures a JAX-RS endpoint.
 */
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {

    @Inject
    private MetricRegistry registry;

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> clazzes = new HashSet<>();

        clazzes.add(MetricsResource.class);
        clazzes.add(HealthcheckResource.class);

        return clazzes;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(new InstrumentedResourceMethodApplicationListener(registry));
    }
}
