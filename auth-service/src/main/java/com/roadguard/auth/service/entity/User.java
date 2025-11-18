package com.roadguard.auth.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    private UUID id;

    @Column(unique = true)
    private String email;
    private String password;
    private boolean enabled = true;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
}
