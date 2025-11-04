package com.roadguard.monitoring.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EarRangeRequest {
    private String driverId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
