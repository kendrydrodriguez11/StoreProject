package com.proyecto2.demo.auth.Service;
import com.proyecto2.demo.auth.AuthModels.UserModels;
import com.proyecto2.demo.auth.User.UserRole;
import com.proyecto2.demo.auth.controllers.AuthResponse;
import com.proyecto2.demo.auth.controllers.request.LoginRequest;
import com.proyecto2.demo.auth.Dao.AuthDao;
import com.proyecto2.demo.auth.controllers.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final AuthDao authDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthDetalis authDetalis;


    @Override
    public AuthResponse login(LoginRequest request) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
            }catch (Exception e){
                System.out.println("error aqui"+ e);
            }
            UserModels userName = authDetalis.finByName(request.getUserName()).orElseThrow();

            String token = jwtService.getToken(userName);
            return AuthResponse.builder()
                    .token(token)
                    .build();

    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        try{
            if (!request.getPassword1().equals(request.getPassword2())) {
                throw new Exception("Passwords do not match");
            }
            UserModels user = UserModels.builder()
                    .userName(request.getName())
                    .lastName(request.getLastName())
                    .password(passwordEncoder.encode(request.getPassword1()))
                    .mail(request.getMail())
                    .role(UserRole.USER)
                    .build();
            UserModels UserRegister = authDao.register(user);
            if (UserRegister != null) {
                return AuthResponse.builder()
                        .token(jwtService.getToken(user))
                        .build();
            }else{
                throw new Exception("User could not be registered");
            }
        }catch (Exception e){
            System.err.println("Error in the service: " + e.getMessage());
            return null;
        }
    }


}
