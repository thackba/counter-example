package org.example.counter.domain;

public class IncrementResult {

    final public static IncrementResult WRONG_INCREMENT_RESULT = new IncrementResult(null, ResultCode.WRONG_INCREMENT);

    final private CounterValue counterValue;
    final private ResultCode resultCode;

    public IncrementResult(CounterValue counterValue, ResultCode resultCode) {
        this.counterValue = counterValue;
        this.resultCode = resultCode;
    }

    public CounterValue getCounterValue() {
        return counterValue;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
