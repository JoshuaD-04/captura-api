package com.joshua.registrioApi.service;

import com.joshua.registrioApi.Model.Registro;
import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.RegistroRequest;
import com.joshua.registrioApi.repository.RegistroRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RegistroService {

    private final RegistroRepository registroRepo;

    public RegistroService(RegistroRepository registroRepo) {
        this.registroRepo = registroRepo;
    }

    public Registro save(RegistroRequest request, Usuario usuario) {

        if (request.getNumeroLote() <= 0) {
            throw new RuntimeException("El número de lote debe ser mayor que 0");
        }
        if (request.getUnidades() == null || request.getUnidades().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El número de unidades debe ser mayor que 0");
        }
        Registro registro = new Registro();
        registro.setCodigoProducto(request.getCodigoProducto());
        registro.setPoliza(request.getPoliza());
        registro.setUbicacion(request.getUbicacion());
        registro.setUnidades(request.getUnidades());
        registro.setNumeroLote(request.getNumeroLote());
        registro.setUsuario(usuario);

        return registroRepo.save(registro);
    }
}

