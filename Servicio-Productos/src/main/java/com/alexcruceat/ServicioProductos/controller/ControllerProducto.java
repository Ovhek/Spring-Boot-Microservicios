package com.alexcruceat.ServicioProductos.controller;

import com.alexcruceat.ServicioProductos.dto.RespuestaProducto;
import com.alexcruceat.ServicioProductos.dto.SolicitudProducto;
import com.alexcruceat.ServicioProductos.model.Producto;
import com.alexcruceat.ServicioProductos.service.ServicioProducto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador Del Producto.
 * @RestController --> Declaramos que es una REST API.
 * @RequestMapping --> Endpoint de la API /api/producto
 */
@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ControllerProducto {

    //Servicio del Producto inyectado.
    private final ServicioProducto servicioProducto;

    /**
     * EndPoint para crear un producto.
     * @param solicitudProducto Producto a crear.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void crearProducto(@RequestBody SolicitudProducto solicitudProducto){
        servicioProducto.crearProducto(solicitudProducto);
    }

    /**
     * EndPoint para obtener todos los productos.
     * @return Todos los productos de la DB
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RespuestaProducto> obtenerProductos(){
        return servicioProducto.obtenerProductos();
    }
}
