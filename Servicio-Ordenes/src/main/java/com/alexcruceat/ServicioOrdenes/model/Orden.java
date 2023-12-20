package com.alexcruceat.ServicioOrdenes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entidad que referencia a una orden de Pedidos
 */
@Entity
@Table(name="t_ordenes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numOrden;
    @OneToMany(cascade = CascadeType.ALL)
    private List<LineaOrden> lineasPedido;
}
