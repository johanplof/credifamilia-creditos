package com.credifamilia.creditos.entity;

import jakarta.persistence.*;

@Entity
public class SolicitudCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    private boolean activa = true;

    public SolicitudCredito() {
    }

    // 👇 ESTE ES EL QUE FALTA
    public SolicitudCredito(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.activa = true;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}