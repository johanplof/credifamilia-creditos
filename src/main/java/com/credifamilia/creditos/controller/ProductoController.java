package com.credifamilia.creditos.controller;
import com.credifamilia.creditos.entity.Producto;
import com.credifamilia.creditos.entity.Cliente;
import com.credifamilia.creditos.service.ProductoService;
import com.credifamilia.creditos.service.SolicitudService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final SolicitudService solicitudService;

    public ProductoController(ProductoService productoService,
                              SolicitudService solicitudService) {
        this.productoService = productoService;
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    @GetMapping("/{id}/clientes")
    public List<Cliente> clientesPorProducto(@PathVariable Long id) {
        return solicitudService.obtenerClientesPorProducto(id);
    }
}