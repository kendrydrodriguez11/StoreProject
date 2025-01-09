package com.proyecto2.demo.auth.Service;
import com.proyecto2.demo.auth.AuthModels.UserModels;
import com.proyecto2.demo.auth.Dao.AuthDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthDetalisImpl implements  AuthDetalis{
    private final AuthDao authDao;

    @Override
    public Optional<UserModels> finByName(String name) {
        return Optional.ofNullable(authDao.finByName(name));
    }

}
