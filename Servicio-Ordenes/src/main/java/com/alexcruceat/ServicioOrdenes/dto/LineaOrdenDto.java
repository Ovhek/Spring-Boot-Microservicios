package com.alexcruceat.ServicioOrdenes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaOrdenDto {
    private Long id;
    private String sku;
    private BigDecimal precio;
    private Integer cantidad;
}
