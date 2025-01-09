package com.proyecto2.demo.auth.Service;

import com.proyecto2.demo.auth.controllers.AuthResponse;
import com.proyecto2.demo.auth.controllers.request.LoginRequest;
import com.proyecto2.demo.auth.controllers.request.RegisterRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);


}
