package com.proyecto2.demo.config;

import com.proyecto2.demo.auth.Dao.AuthDao;
import com.proyecto2.demo.auth.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor

public class applicationsConfig {
    private final AuthService authService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return  config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider  authenticatePovider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return  authenticationProvider;

    }

    @Bean
    private PasswordEncoder passwordEncoder() {

    }

    @Bean
    private UserDetailsService userDetailsService() {
        return username -> authService.finByName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

    }
}
