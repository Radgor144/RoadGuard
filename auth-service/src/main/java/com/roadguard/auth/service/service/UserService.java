package com.roadguard.auth.service.service;

import com.roadguard.auth.service.dto.AuthResponse;
import com.roadguard.auth.service.dto.UserCredentialsRequest;
import com.roadguard.auth.service.entity.Role;
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

    public AuthResponse registerUser(UserCredentialsRequest request) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setEnabled(true);

        userRepository.save(user);

        String token = tokenService.generateToken(user);
        return new AuthResponse(token, "Bearer");
    }

    public AuthResponse loginUser(UserCredentialsRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                                  .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = tokenService.generateToken(user);
        return new AuthResponse(token, "Bearer");
    }
}
