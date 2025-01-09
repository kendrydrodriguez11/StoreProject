package com.proyecto2.demo.auth.controllers.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @NotBlank
    String password1;
    @NotBlank
    String password2;
    @NotBlank @Email
    String mail;
}
