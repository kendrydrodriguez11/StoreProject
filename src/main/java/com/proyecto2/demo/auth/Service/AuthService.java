package com.proyecto2.demo.auth.Service;

import com.proyecto2.demo.auth.AuthModels.UserModels;
import com.proyecto2.demo.auth.controllers.AuthResponse;
import com.proyecto2.demo.auth.controllers.LoginRequest;

import java.util.Optional;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(LoginRequest request);

    Optional<UserModels> finByName(String name);

}
