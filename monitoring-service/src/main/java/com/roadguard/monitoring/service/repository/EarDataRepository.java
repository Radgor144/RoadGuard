package com.roadguard.monitoring.service.repository;

import com.roadguard.monitoring.service.entity.EarData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarDataRepository extends JpaRepository<EarData, Long> {}
