package com.proyecto2.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigControllers {
    @Bean
    public SecurityFilterChain Security(HttpSecurity http) throws  Exception
    {
        return  http
                .csrf(csrf ->
                        csrf.disable())
                .authorizeHttpRequests(authoRequest->
                       authoRequest
                               .requestMatchers("/outh/**").permitAll()
                               .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
