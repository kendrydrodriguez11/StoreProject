package com.proyecto2.demo.auth.controllers;

import com.proyecto2.demo.auth.Service.AuthServiceImpl;
import com.proyecto2.demo.auth.controllers.request.LoginRequest;
import com.proyecto2.demo.auth.controllers.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class Auth {
    private final AuthServiceImpl authServiceImpl;


    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        try {
            AuthResponse response = authServiceImpl.register(request);
            if(response == null){
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new AuthResponse("Registracion fail: user could not be registered"));
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthResponse("Error registering user: " + e.getMessage()));
        }
    }


    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> getUsers(@RequestBody LoginRequest request){
        try{
            AuthResponse response = authServiceImpl.login(request);
            if(response == null){
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new AuthResponse("User not are login"));
            }
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new AuthResponse("Error login user: " + e.getMessage()));
        }


    }




}
