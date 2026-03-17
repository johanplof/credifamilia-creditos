package com.credifamilia.creditos.service;

import com.credifamilia.creditos.entity.Producto;
import com.credifamilia.creditos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // Crear un producto
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto por id
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

}