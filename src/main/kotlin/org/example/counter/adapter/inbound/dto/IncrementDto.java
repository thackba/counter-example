package org.example.counter.adapter.inbound.dto;

import javax.validation.constraints.NotNull;

public class IncrementDto {

    @NotNull
    final private Integer increment;

    public IncrementDto(Integer increment) {
        this.increment = increment;
    }

    public Integer getIncrement() {
        return increment;
    }
}
