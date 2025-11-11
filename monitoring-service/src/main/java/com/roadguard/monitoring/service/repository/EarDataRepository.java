package com.roadguard.monitoring.service.repository;

import com.roadguard.monitoring.service.entity.EarData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EarDataRepository extends JpaRepository<EarData, UUID> {
    List<EarData> findByDriverIdAndTimestampBetweenOrderByTimestampAsc(UUID driverId, LocalDateTime startTime, LocalDateTime endTime);
}
