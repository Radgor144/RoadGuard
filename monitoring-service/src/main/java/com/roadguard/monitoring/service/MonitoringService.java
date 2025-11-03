package com.roadguard.monitoring.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitoringService {
    public static void main(String[] args) {
        SpringApplication.run(MonitoringService.class, args);
    }
}