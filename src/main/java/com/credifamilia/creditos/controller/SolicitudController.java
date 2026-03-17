package com.credifamilia.creditos.controller;

import com.credifamilia.creditos.entity.SolicitudCredito;
import com.credifamilia.creditos.service.SolicitudService;
import com.credifamilia.creditos.dto.CrearSolicitudDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public SolicitudCredito crearSolicitud(@RequestBody CrearSolicitudDTO dto) {

        return solicitudService.crearSolicitud(
                dto.getClienteId(),
                dto.getProductoId()
        );
    }
    @GetMapping
    public List<SolicitudCredito> obtenerSolicitudes() {
        return solicitudService.obtenerSolicitudes();
    }
}