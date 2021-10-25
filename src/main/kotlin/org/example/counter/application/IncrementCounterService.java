package org.example.counter.application;

import org.example.counter.application.inbound.IncrementCounter;
import org.example.counter.domain.IncrementResult;
import org.example.counter.domain.ResultCode;
import org.example.counter.application.outbound.CRUDCounterValue;
import org.example.counter.domain.CounterValue;
import org.example.counter.domain.Increment;

import static org.example.counter.domain.IncrementResult.WRONG_INCREMENT_RESULT;

public class IncrementCounterService implements IncrementCounter {

    final private CRUDCounterValue CRUDCounterValue;

    public IncrementCounterService(CRUDCounterValue CRUDCounterValue) {
        this.CRUDCounterValue = CRUDCounterValue;
    }

    @Override
    public IncrementResult increment(Increment increment) {
        if (increment != null && increment.getValue() > 0 && increment.getValue() < 100) { // Symantische Prüfung
            var counterValue = CRUDCounterValue.loadCounterValue();
            if (counterValue.getValue() + increment.getValue() > 10_000_000) {
                return new IncrementResult(null, ResultCode.COUNTER_OVERFLOW);
            } else {
                var newCounterValue = new CounterValue(counterValue.getValue() + increment.getValue());
                CRUDCounterValue.saveCounterValue(newCounterValue);
                return new IncrementResult(newCounterValue, ResultCode.OK);
            }
        } else {
            return WRONG_INCREMENT_RESULT;
        }
    }
}
