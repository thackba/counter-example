package org.example.counter.adapter.outbound;

import org.example.counter.application.outbound.CRUDCounterValue;
import org.example.counter.domain.CounterValue;

public class InMemoryStorage implements CRUDCounterValue {

    private CounterValue counterValue;

    @Override
    public CounterValue loadCounterValue() {
        if (counterValue == null) {
            return new CounterValue(0);
        }
        return counterValue;
    }

    @Override
    public void saveCounterValue(CounterValue counterValue) {
        this.counterValue = counterValue;
    }
}
