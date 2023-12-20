package com.alexcruceat.ServicioOrdenes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_linea_orden")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineaOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private BigDecimal precio;
    private Integer cantidad;
}
