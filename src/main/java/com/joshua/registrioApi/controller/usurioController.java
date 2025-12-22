package com.joshua.registrioApi.controller;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.service.UsuarioService;
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
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<Usuario> buscar(@PathVariable String nombre){
        return usuarioService.findByName(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
