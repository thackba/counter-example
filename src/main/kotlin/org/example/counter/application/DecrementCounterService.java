package org.example.counter.application;

import org.example.counter.application.outbound.CRUDCounterValue;

public class DecrementCounterService {

    final private CRUDCounterValue CRUDCounterValue;
    final private SaveCounterValue saveCounterValue;

    public DecrementCounterService(CRUDCounterValue CRUDCounterValue, SaveCounterValue saveCounterValue) {
        this.CRUDCounterValue = CRUDCounterValue;
        this.saveCounterValue = saveCounterValue;
    }


}
