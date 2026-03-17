package com.credifamilia.creditos.service;
import com.credifamilia.creditos.entity.Cliente;
import com.credifamilia.creditos.entity.Producto;
import com.credifamilia.creditos.entity.SolicitudCredito;
import com.credifamilia.creditos.repository.ClienteRepository;
import com.credifamilia.creditos.repository.ProductoRepository;
import com.credifamilia.creditos.repository.SolicitudRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    public SolicitudService(SolicitudRepository solicitudRepository,
                            ClienteRepository clienteRepository,
                            ProductoRepository productoRepository) {

        this.solicitudRepository = solicitudRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    public SolicitudCredito crearSolicitud(Long clienteId, Long productoId) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente no encontrado"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producto no encontrado"));

        // Regla 1: máximo 30 solicitudes por producto
        long solicitudesProducto = solicitudRepository.countByProductoIdAndActivaTrue(productoId);

        if (solicitudesProducto >= 30) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "No hay cupos disponibles para este producto"
            );
        }

        // Regla 2: no duplicar solicitud cliente-producto
        boolean existeSolicitud = solicitudRepository
                .existsByClienteIdAndProductoIdAndActivaTrue(clienteId, productoId);

        if (existeSolicitud) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El cliente ya tiene una solicitud activa para este producto"
            );
        }

        // Regla 3: máximo 3 créditos por cliente
        long solicitudesCliente = solicitudRepository.countByClienteIdAndActivaTrue(clienteId);

        if (solicitudesCliente >= 3) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El cliente ya tiene 3 créditos activos"
            );
        }

        SolicitudCredito solicitud = new SolicitudCredito(cliente, producto);

        return solicitudRepository.save(solicitud);
    }

    public List<SolicitudCredito> obtenerSolicitudes() {
        return solicitudRepository.findAll();
    }
    public List<Cliente> obtenerClientesPorProducto(Long productoId) {
        return solicitudRepository.findClientesByProductoId(productoId);
    }
    public List<Producto> obtenerProductosPorCliente(Long clienteId) {
        return solicitudRepository.findProductosByClienteId(clienteId);
    }
}
