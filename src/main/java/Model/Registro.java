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

    //Constructores
    public Registro() {}

    public Registro(Long idRegistro, String poliza, String codigoProducto, int numeroLote, BigDecimal unidades, String ubicacion, LocalDate fechaRegistro, Usuario usuario) {
        this.idRegistro = idRegistro;
        this.poliza = poliza;
        this.codigoProducto = codigoProducto;
        this.numeroLote = numeroLote;
        this.unidades = unidades;
        this.ubicacion = ubicacion;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
    }

    //getters y setters

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public BigDecimal getUnidades() {
        return unidades;
    }

    public void setUnidades(BigDecimal unidades) {
        this.unidades = unidades;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //ToString

    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", poliza='" + poliza + '\'' +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", numeroLote=" + numeroLote +
                ", unidades=" + unidades +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
