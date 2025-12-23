    package com.joshua.registrioApi.dto;

    public class UsuarioResponse {
        private Long id;
        private String codigoUsuario;
        private String nombre;

        public UsuarioResponse(Long id, String codigoUsuario, String nombre) {
            this.id = id;
            this.codigoUsuario = codigoUsuario;
            this.nombre = nombre;
        }

        public Long getId() {
            return id;
        }

        public String getCodigoUsuario() {
            return codigoUsuario;
        }

        public String getNombre() {
            return nombre;
        }
    }
