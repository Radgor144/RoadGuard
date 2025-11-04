package com.roadguard.monitoring.service.repository;

import com.roadguard.monitoring.service.entity.EarData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EarDataRepository extends JpaRepository<EarData, Long> {
    List<EarData> findByDriverIdAndTimestampBetweenOrderByTimestampAsc(String driverId, LocalDateTime startTime, LocalDateTime endTime);
}
