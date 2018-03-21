package com.packtpub.javaee8;

import com.packtpub.javaee8.jwt.AuthenticationResource;
import com.packtpub.javaee8.jwt.JwtAuthzVerifier;
import com.packtpub.javaee8.validation.BooksResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Configures a JAX-RS endpoint.
 */
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(BooksResource.class);

        classes.add(AuthenticationResource.class);
        classes.add(JwtAuthzVerifier.class);

        // TODO activate us
        // classes.add(LoggingFeature.class);
        // classes.add(MetricsResource.class);

        return classes;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();

        // TODO add logging properties

        return properties;
    }
}
