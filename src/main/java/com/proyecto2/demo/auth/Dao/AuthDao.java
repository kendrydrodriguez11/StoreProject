package com.proyecto2.demo.auth.Dao;

import com.proyecto2.demo.auth.AuthModels.UserModels;
import com.proyecto2.demo.auth.controllers.AuthResponse;
import com.proyecto2.demo.auth.controllers.request.LoginRequest;

public interface AuthDao {


    AuthResponse login(LoginRequest request);

    UserModels finByName(String name);

    UserModels register(UserModels user);
}


//hacer la base de datos