package com.joshua.registrioApi.controller;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.UsuarioRequest;
import com.joshua.registrioApi.dto.UsuarioResponse;
import com.joshua.registrioApi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class usurioController {
    private final UsuarioService usuarioService;

    public usurioController(UsuarioService usurioService) {
        this.usuarioService = usurioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioResponse> crear(@Valid  @RequestBody UsuarioRequest userReq){
        Usuario usuario = usuarioService.save(userReq);

        UsuarioResponse response = new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getCodigoUsuario(),
                usuario.getNombre()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<Usuario> buscar(@PathVariable String nombre){
        return usuarioService.findByName(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
