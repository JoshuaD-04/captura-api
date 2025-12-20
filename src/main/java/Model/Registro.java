package Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @Column(name = "poliza", nullable = false, length = 255)
    private String poliza;

    @Column(name = "codigoProducto", nullable = false, length = 200)
    private String codigoProducto;

    @Column(name = "numLote", nullable = false)
    private int numeroLote;

    @Column(name = "unidades", nullable = false, precision = 10, scale = 4)
    private BigDecimal unidades;

    @Column(name = "ubicacion", nullable = false, length = 200)
    private String ubicacion;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @PrePersist
    void onCreate() {
        this.fechaRegistro = LocalDate.now();
    }


}
