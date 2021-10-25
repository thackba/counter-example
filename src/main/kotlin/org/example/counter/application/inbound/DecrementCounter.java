package org.example.counter.application.inbound;

import org.example.counter.domain.Decrement;
import org.example.counter.domain.IncrementResult;

public interface DecrementCounter {

    IncrementResult decrement(Decrement increment);
}
