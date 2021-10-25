package org.example.counter.adapter.inbound;

import org.example.counter.application.inbound.IncrementCounter;
import org.example.counter.domain.Increment;

import java.nio.ByteBuffer;

public class CounterListener {

    final private IncrementCounter incrementCounter;

    public CounterListener(IncrementCounter incrementCounter) {
        this.incrementCounter = incrementCounter;
    }

    public void listen(ByteBuffer event) {
        // Versionierung
        incrementCounter.increment(new Increment(0));
    }
}
