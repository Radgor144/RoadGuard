package com.roadguard.monitoring.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class EarDataResponse {
    private LocalDateTime timestamp;
    private double averageEar;
}

