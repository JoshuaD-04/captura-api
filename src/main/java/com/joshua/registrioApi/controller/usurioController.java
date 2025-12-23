package com.joshua.registrioApi.controller;

import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.LoginRequest;
import com.joshua.registrioApi.dto.UsuarioRequest;
import com.joshua.registrioApi.dto.UsuarioResponse;
import com.joshua.registrioApi.service.AuthService;
import com.joshua.registrioApi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class usurioController {
    private final UsuarioService usuarioService;
    private final AuthService authService;

    public usurioController(UsuarioService usurioService, AuthService authService) {
        this.usuarioService = usurioService;
        this.authService = authService;
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponse> crear(@Valid  @RequestBody UsuarioRequest userReq){
        Usuario usuario = usuarioService.save(userReq);

        UsuarioResponse response = new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getCodigoUsuario(),
                usuario.getNombre()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody LoginRequest request){
        Usuario u = authService.login(
                request.getNombre(),
                request.getPassword()
        );
        return ResponseEntity.ok(
                new UsuarioResponse(
                        u.getIdUsuario(),
                        u.getCodigoUsuario(),
                        u.getNombre()
                )
        );
    }
}
