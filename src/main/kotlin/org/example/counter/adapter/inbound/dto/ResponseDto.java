package org.example.counter.adapter.inbound.dto;

import org.example.counter.domain.CounterValue;

public class ResponseDto {

    private CounterValue counterValue;

    public ResponseDto(CounterValue counterValue) {
        this.counterValue = counterValue;
    }

    public CounterValue getCounterValue() {
        return counterValue;
    }

    public void setCounterValue(CounterValue counterValue) {
        this.counterValue = counterValue;
    }
}
