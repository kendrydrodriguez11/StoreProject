package com.proyecto2.demo.auth.controllers;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthResponse {
    private String token;
}
