package com.joshua.registrioApi.controller;

import com.joshua.registrioApi.Model.Registro;
import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.RegistroRequest;
import com.joshua.registrioApi.repository.UsuarioRepository;
import com.joshua.registrioApi.service.RegistroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    private final RegistroService registroService;
    private final UsuarioRepository usuarioRepository;

    public RegistroController(
            RegistroService registroService,
            UsuarioRepository usuarioRepository
    ) {
        this.registroService = registroService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/crear/{userId}")
    public ResponseEntity<Registro> crearRegistro(
            @PathVariable Long userId,
            @RequestBody RegistroRequest request
    ) {

        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Registro registro = registroService.save(request, usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }
}

