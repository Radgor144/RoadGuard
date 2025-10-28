package com.roadguard.auth.service.service;

import com.roadguard.auth.service.dto.AuthResponse;
import com.roadguard.auth.service.dto.UserRegistrationRequest;
import com.roadguard.auth.service.entity.User;
import com.roadguard.auth.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthResponse registerUser(UserRegistrationRequest request) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setEnabled(true);

        userRepository.save(user);

        String token = tokenService.generateToken(user);
        return new AuthResponse(token, "Bearer");
    }
}
