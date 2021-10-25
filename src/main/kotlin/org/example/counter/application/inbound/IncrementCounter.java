package org.example.counter.application.inbound;

import org.example.counter.domain.Increment;
import org.example.counter.domain.IncrementResult;

public interface IncrementCounter {

    IncrementResult increment(Increment increment);

}
