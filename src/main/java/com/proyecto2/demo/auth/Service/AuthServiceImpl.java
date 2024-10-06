package com.proyecto2.demo.auth.Service;

import com.proyecto2.demo.auth.AuthModels.UserModels;
import com.proyecto2.demo.auth.User.UserRole;
import com.proyecto2.demo.auth.controllers.AuthResponse;
import com.proyecto2.demo.auth.controllers.LoginRequest;
import com.proyecto2.demo.auth.Dao.AuthDao;
import com.proyecto2.demo.auth.jwt.JwtService;
import com.proyecto2.demo.auth.jwt.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {
    private final AuthDao authDao;
    private final JwtService jwtService;


    @Autowired
    public AuthServiceImpl(AuthDao authDao, JwtService jwtService) {
        this.authDao = authDao;
        this.jwtService = jwtService; // Corregir el nombre de la variable
    }


    @Override
    public AuthResponse login(LoginRequest request) {
        try{
            return authDao.login(request);
        }catch (Exception e){
            throw new RuntimeException("ERROR", e);
        }
    }

    @Override
    public AuthResponse register(LoginRequest request) {
        if (!request.getPassword1().equals(request.getPassword2())) {
            return null;
        }

        UserModels user = UserModels.builder()
                .userName(request.getUserName())
                .lastName(request.getLastName())
                .password1(request.getPassword1())
                .password2(request.getPassword2())
                .mail(request.getMail())
                .role(UserRole.USER)
                .build();
        UserModels UserRegister = authDao.register(user);
        if (UserRegister != null) {
            return AuthResponse.builder()
                    .Token(jwtService.getToken(user))
                    .build();
        } return null;
    }

    @Override
    public Optional<UserModels> finByName(String name) {
        return Optional.ofNullable(authDao.finByName(name));
    }

}
