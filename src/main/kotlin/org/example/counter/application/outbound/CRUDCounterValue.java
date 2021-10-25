package org.example.counter.application.outbound;

import org.example.counter.domain.CounterValue;

public interface CRUDCounterValue {

    CounterValue loadCounterValue();

    void saveCounterValue(CounterValue counterValue);
}
