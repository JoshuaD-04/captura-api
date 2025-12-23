package com.joshua.registrioApi.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class RegistroRequest {
    @NotBlank(message = "Poliza requerida")
    private String poliza;
    @NotBlank(message = "Codigo requerido")
    private String codigoProducto;
    private int numeroLote;
    private BigDecimal unidades;
    @NotBlank(message = "ubicacion Requerida")
    private String ubicacion;

    public String getPoliza() {
        return poliza;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getNumeroLoto() {
        return numeroLote;
    }

    public BigDecimal getUnidades() {
        return unidades;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
