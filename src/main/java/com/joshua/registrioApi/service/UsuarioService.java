package com.joshua.registrioApi.service;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.UsuarioRequest;
import com.joshua.registrioApi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuariorepo;
    private final PasswordEncoder passwordEncoder;
    public UsuarioService(UsuarioRepository usuariorepo, PasswordEncoder passwordEncoder) {
        this.usuariorepo = usuariorepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario save(UsuarioRequest request){

        if(usuariorepo.existsByCodigoUsuario(request.getCodigoUsuario())){
            throw new RuntimeException("El codigo ya existe");
        }
        if(usuariorepo.existsByNombre(request.getNombre())){
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getCodigoUsuario());
        usuario.setNombre(request.getNombre());

        usuario.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        return usuariorepo.save(usuario);

    }
    public Optional<Usuario> findByName(String nombre){
        return usuariorepo.findByNombre(nombre);
    }
    public boolean existByName(String nombre){
        return usuariorepo.findByNombre(nombre).isPresent();
    }
}
