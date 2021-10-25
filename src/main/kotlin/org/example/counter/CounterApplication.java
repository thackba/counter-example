package org.example.counter;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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

        // environment.jersey().register();
    }
}
