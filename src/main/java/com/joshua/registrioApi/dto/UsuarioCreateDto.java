package com.joshua.registrioApi.dto;
import jakarta.validation.constraints.NotBlank;

public class UsuarioCreateDto {
    @NotBlank(message = "El codigo es requerido")
    private String codigoUsuario;
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotBlank(message = "la contraseña es obligatoria")
    private String password;

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
