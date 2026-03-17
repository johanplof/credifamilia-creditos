package com.credifamilia.creditos.dto;

import jakarta.validation.constraints.NotNull;

public class CrearSolicitudDTO {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long productoId;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
}