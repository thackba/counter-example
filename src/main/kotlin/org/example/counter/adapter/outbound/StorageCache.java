package org.example.counter.adapter.outbound;

import org.example.counter.application.outbound.CRUDCounterValue;
import org.example.counter.domain.CounterValue;

public class StorageCache implements CRUDCounterValue {

    final private CRUDCounterValue CRUDCounterValue;

    public StorageCache(CRUDCounterValue CRUDCounterValue) {
        this.CRUDCounterValue = CRUDCounterValue;
    }

    @Override
    public CounterValue loadCounterValue() {
        // Zugriff auf Cache sonst:
        return this.CRUDCounterValue.loadCounterValue();
    }

    @Override
    public void saveCounterValue(CounterValue counterValue) {
        // Cache invalidieren bzw. updaten
        this.CRUDCounterValue.saveCounterValue(counterValue);
    }
}
