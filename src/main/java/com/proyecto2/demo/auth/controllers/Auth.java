package com.proyecto2.demo.auth.controllers;

import com.proyecto2.demo.auth.Service.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/outh")
public class Auth {
    private final AuthServiceImpl authServiceImpl;

    public Auth(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> getUsers(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authServiceImpl.login(request));
    }



    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authServiceImpl.register(request));
    }



}
