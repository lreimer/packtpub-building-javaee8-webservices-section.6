package com.packtpub.javaee8;

import com.packtpub.javaee8.validation.BooksResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
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

        return classes;
    }


}
