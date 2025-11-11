package com.roadguard.monitoring.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EarRangeRequest {
    private UUID driverId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
