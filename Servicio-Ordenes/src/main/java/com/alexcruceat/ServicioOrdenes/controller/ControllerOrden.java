package com.alexcruceat.ServicioOrdenes.controller;

import com.alexcruceat.ServicioOrdenes.dto.SolicitudOrden;
import com.alexcruceat.ServicioOrdenes.service.ServicioOrden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de los Pedidos, accesible mediante el endpoint "/api/orden"
 */
@RestController
@RequestMapping("/api/orden")
@RequiredArgsConstructor
public class ControllerOrden {

    private final ServicioOrden servOrden;
    /**
     * Realiza la orden recibida desde la solicitud.
     * @param solicitud Orden recibida en el body de tipo {@link SolicitudOrden}
     * @return Respuesta según proceso.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String realizarOrden(@RequestBody SolicitudOrden solicitud){

        servOrden.realizarOrden(solicitud);
        return "Orden realizada.";
    }
}
