package org.example.counter.metrics;

import com.codahale.metrics.health.HealthCheck;

public class SimpleHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return HealthCheck.Result.healthy();
    }
}
