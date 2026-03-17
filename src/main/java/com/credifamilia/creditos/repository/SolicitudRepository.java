package com.credifamilia.creditos.repository;

import com.credifamilia.creditos.entity.Cliente;
import com.credifamilia.creditos.entity.Producto;
import com.credifamilia.creditos.entity.SolicitudCredito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<SolicitudCredito, Long> {

    long countByProductoIdAndActivaTrue(Long productoId);

    long countByClienteIdAndActivaTrue(Long clienteId);

    boolean existsByClienteIdAndProductoIdAndActivaTrue(Long clienteId, Long productoId);

    @Query("SELECT s.cliente FROM SolicitudCredito s WHERE s.producto.id = :productoId AND s.activa = true")
    List<Cliente> findClientesByProductoId(@Param("productoId") Long productoId);
    @Query("SELECT s.producto FROM SolicitudCredito s WHERE s.cliente.id = :clienteId AND s.activa = true")
    List<Producto> findProductosByClienteId(@Param("clienteId") Long clienteId);
}