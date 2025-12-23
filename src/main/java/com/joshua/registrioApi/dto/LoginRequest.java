package com.joshua.registrioApi.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
}
