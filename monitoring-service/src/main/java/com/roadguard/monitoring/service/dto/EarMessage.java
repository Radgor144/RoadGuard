package com.roadguard.monitoring.service.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EarMessage {
    @NotNull
    private String driverId;

    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private Double ear;
    private long timestamp;
}
