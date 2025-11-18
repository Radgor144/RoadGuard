package com.roadguard.auth.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentialsRequest {
    private String email;
    private String password;
}

