package com.joshua.registrioApi.repository;

import com.joshua.registrioApi.Model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    //Optional<Registro> findByRegistro(String codigo);

}
