package com.joshua.registrioApi.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "codigo_usuario", nullable = false, unique = true, length = 100)
    private String codigoUsuario;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "fechaRegistro")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistrado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Registro>  registros = new ArrayList();

    @PrePersist
    void onCreate() {
        this.fechaRegistrado = LocalDate.now();
    }

    //Constructores
    public Usuario() {}

    public Usuario(Long idUsuario,String codigoUsuario, String nombre, String password, LocalDate fechaRegistrado, List<Registro> registros) {
        this.idUsuario = idUsuario;
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.password = password;
        this.fechaRegistrado = fechaRegistrado;
        this.registros = registros;
    }
    //getters y setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCodigoUsuario() {
        return codigoUsuario;
    }
    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistrado() {
        return fechaRegistrado;
    }

    public void setFechaRegistrado(LocalDate fechaRegistrado) {
        this.fechaRegistrado = fechaRegistrado;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    //ToString

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                "codigoUsuarii=" + codigoUsuario +
                ", nombre='" + nombre + '\'' +
                ", fechaRegistrado=" + fechaRegistrado +
                '}';
    }
}
