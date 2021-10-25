package org.example.counter;

import org.example.counter.application.IncrementCounterService;
import org.example.counter.application.outbound.CRUDCounterValue;
import org.example.counter.domain.CounterValue;

import static org.mockito.Mockito.mock;

public class IncrementCounterServiceTest {

    final private CRUDCounterValue CRUDCounterValue = mock(CRUDCounterValue.class);

    final private IncrementCounterService cut = new IncrementCounterService(CRUDCounterValue);

    // normale funktion
    // Falsche increment
    // Counter overflow
}
