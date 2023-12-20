package com.alexcruceat.ServicioOrdenes.dto;

import com.alexcruceat.ServicioOrdenes.model.LineaOrden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudOrden {

    //Lista de lineas de pedido.
    private List<LineaOrdenDto> lineasOrdenDto;

}
