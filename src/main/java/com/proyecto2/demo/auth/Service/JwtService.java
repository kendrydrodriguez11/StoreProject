package com.proyecto2.demo.auth.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String getToken(UserDetails user);
}
