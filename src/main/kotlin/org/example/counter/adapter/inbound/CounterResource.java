package org.example.counter.adapter.inbound;

import org.example.counter.adapter.inbound.dto.IncrementDto;
import org.example.counter.adapter.inbound.dto.ResponseDto;
import org.example.counter.application.inbound.IncrementCounter;
import org.example.counter.domain.ResultCode;
import org.example.counter.domain.Increment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/increment")
@Produces(MediaType.APPLICATION_JSON)
public class CounterResource {

    final private IncrementCounter incrementCounter;

    public CounterResource(IncrementCounter incrementCounter) {
        this.incrementCounter = incrementCounter;
    }

    @POST
    public ResponseDto increment(@NotNull @Valid IncrementDto incrementDto) {
        if (incrementDto.getIncrement() == null) { // Syntaktische Validierung
            throw new IllegalArgumentException("Fehler");
        }
        var response = incrementCounter.increment(new Increment(incrementDto.getIncrement())); // Mapping
        if (response.getResultCode() == ResultCode.OK) {
            return new ResponseDto(response.getCounterValue()); // Mapping
        } else {
            throw new IllegalArgumentException("Fehler");
        }
    }
}
