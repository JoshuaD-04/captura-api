package com.joshua.registrioApi.service;

import com.joshua.registrioApi.Model.Registro;
import com.joshua.registrioApi.Model.Usuario;
import com.joshua.registrioApi.dto.RegistroRequest;
import com.joshua.registrioApi.repository.RegistroRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    private final RegistroRepository registroRepo;

    public RegistroService(RegistroRepository registroRepo) {
        this.registroRepo = registroRepo;
    }
    public Registro save(RegistroRequest request, Usuario usuario){
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
