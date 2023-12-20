package com.alexcruceat.ServicioProductos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO de la respuesta.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaProducto {
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}
