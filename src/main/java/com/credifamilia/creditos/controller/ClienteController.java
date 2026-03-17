package com.credifamilia.creditos.controller;

import com.credifamilia.creditos.entity.Producto;
import com.credifamilia.creditos.service.SolicitudService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final SolicitudService solicitudService;

    public ClienteController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping("/{id}/productos")
    public List<Producto> obtenerProductosPorCliente(@PathVariable Long id) {
        return solicitudService.obtenerProductosPorCliente(id);
    }
}