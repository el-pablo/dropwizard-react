package org.elpablo.beer;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BeerApplication extends Application<BeerConfiguration> {
    public static void main(String[] args) throws Exception {
        new BeerApplication().run(args);
    }

    @Override
    public String getName() {
        return "beer";
    }

    @Override
    public void initialize(Bootstrap<BeerConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/app", "/", "index.html"));
    }

    @Override
    public void run(BeerConfiguration configuration,
                    Environment environment) {
        final BeerResource resource = new BeerResource(
                configuration.getTemplate(),
                configuration.getDefaultName(),
                new BeerRepository());
        final BeerCheck healthCheck =
                new BeerCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().setUrlPattern("/api/*");
    }

}