package com.proyecto2.demo.auth.Service;

import com.proyecto2.demo.auth.AuthModels.UserModels;

import java.util.Optional;

public interface AuthDetalis {
    Optional<UserModels> finByName(String name);
}
