package Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "fechaRegistro")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistrado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Registro>  registros = new ArrayList();

    @PrePersist
    void onCreate() {
        this.fechaRegistrado = LocalDate.now();
    }



}
