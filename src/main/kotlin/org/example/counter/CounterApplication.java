package org.example.counter;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.counter.adapter.inbound.CounterResource;
import org.example.counter.adapter.outbound.InMemoryStorage;
import org.example.counter.adapter.outbound.StorageCache;
import org.example.counter.application.IncrementCounterService;
import org.example.counter.metrics.SimpleHealthCheck;
import org.jdbi.v3.core.Jdbi;

public class CounterApplication extends Application<CounterConfiguration> {

    public static void main(String[] args) throws Exception {
        new CounterApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<CounterConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<>() {
            @Override
            public DataSourceFactory getDataSourceFactory(CounterConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(CounterConfiguration configuration, Environment environment) throws Exception {
        final var simpleHealthCheck = new SimpleHealthCheck();
        environment.healthChecks().register("simple", simpleHealthCheck);

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        // Outbound
        var storage = new InMemoryStorage();
        var cache = new StorageCache(storage);

        // Service
        var incrementCounterService = new IncrementCounterService(cache);

        // Inbound
        var resource = new CounterResource(incrementCounterService);
        environment.jersey().register(resource);
    }
}
