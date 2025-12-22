package com.joshua.registrioApi.controller;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.service.UsuarioService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class usurioController {
    private final UsuarioService usurioService;

    public usurioController(UsuarioService usurioService) {
        this.usurioService = usurioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usurioService.save(usuario));
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<Usuario> buscar(@PathVariable String nombre){
        return usurioService.findByName(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
