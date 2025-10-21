package com.roadguard.auth.service.dto;

import com.roadguard.auth.service.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
    private String username;
    private String password;
    private Role role = Role.USER;
}

