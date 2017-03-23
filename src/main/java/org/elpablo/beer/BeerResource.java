package org.elpablo.beer;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/beer")
@Produces(MediaType.APPLICATION_JSON)
public class BeerResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final BeerRepository repository;

    public BeerResource(String template, String defaultName, BeerRepository repository) {
        this.template = template;
        this.defaultName = defaultName;
        this.repository = repository;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public List<Beer> getBeers() {
        return repository.getBeers();
    }
}