package com.joshua.registrioApi.service;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.UsuarioRequest;
import com.joshua.registrioApi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuariorepo;

    public UsuarioService(UsuarioRepository usuariorepo) {
        this.usuariorepo = usuariorepo;
    }

    public Usuario save(UsuarioRequest request){

        if(usuariorepo.existsByCodigoUsuario(request.getCodigoUsuario())){
            throw new RuntimeException("El codigo ya existe");
        }
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario(request.getCodigoUsuario());
        usuario.setNombre(request.getNombre());
        usuario.setPassword(request.getPassword());

        return usuariorepo.save(usuario);

    }
    public Optional<Usuario> findByName(String nombre){
        return usuariorepo.findByNombre(nombre);
    }
    public boolean existByName(String nombre){
        return usuariorepo.findByNombre(nombre).isPresent();
    }
}
