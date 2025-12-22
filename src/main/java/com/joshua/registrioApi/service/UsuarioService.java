package com.joshua.registrioApi.service;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuariorepo;

    public UsuarioService(UsuarioRepository usuariorepo) {
        this.usuariorepo = usuariorepo;
    }

    public Usuario save(Usuario usuario){
        return usuariorepo.save(usuario);
    }
    public Optional<Usuario> findByName(String nombre){
        return usuariorepo.findByNombre(nombre);
    }
    public boolean existByName(String nombre){
        return usuariorepo.findByNombre(nombre).isPresent();
    }
}
