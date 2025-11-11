package com.roadguard.auth.service.controller;

import com.roadguard.auth.service.dto.AuthResponse;
import com.roadguard.auth.service.dto.UserCredentialsRequest;
import com.roadguard.auth.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody UserCredentialsRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody UserCredentialsRequest request) {
        return userService.loginUser(request);
    }

}
