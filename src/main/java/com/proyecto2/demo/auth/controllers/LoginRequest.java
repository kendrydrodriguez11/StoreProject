package com.proyecto2.demo.auth.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequest {
    String userName;
    String lastName;
    String password1;
    String password2;
    String mail;
    String rol;
}
