package com.roadguard.monitoring.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping
    public ResponseEntity<String> getDashboard(Authentication authentication) {
        return ResponseEntity.ok("Dashboard dostępny dla użytkownika: " + authentication.getName());
    }
}
