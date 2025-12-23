package com.joshua.registrioApi.service;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario login(String nombre, String password){
        Usuario usuario = usuarioRepo.findByNombre(nombre)
                .orElseThrow(()-> new RuntimeException("Usuario no existe"));

        if(!passwordEncoder.matches(password, usuario.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }
        return usuario;
    }
}
