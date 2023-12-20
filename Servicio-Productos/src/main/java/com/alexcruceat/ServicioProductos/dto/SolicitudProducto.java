package com.alexcruceat.ServicioProductos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO del Producto que incluye el nombre, descripción y precio.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudProducto {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}
