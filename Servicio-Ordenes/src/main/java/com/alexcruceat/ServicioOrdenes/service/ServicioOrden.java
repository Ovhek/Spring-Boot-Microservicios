package com.alexcruceat.ServicioOrdenes.service;

import com.alexcruceat.ServicioOrdenes.dto.LineaOrdenDto;
import com.alexcruceat.ServicioOrdenes.dto.SolicitudOrden;
import com.alexcruceat.ServicioOrdenes.model.LineaOrden;
import com.alexcruceat.ServicioOrdenes.model.Orden;
import com.alexcruceat.ServicioOrdenes.repository.RepositorioOrden;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicioOrden {

    //Inyección mediante constructor del repositorio de Ordenes.
    private final RepositorioOrden repoOrden;

    /**
     * Guardamos la orden en la base de datos.
     * @param solicitud DTO {@link SolicitudOrden} correspondent a la entidad {@link Orden}
     */
    public void realizarOrden(SolicitudOrden solicitud){
        //Creamos un objeto de la Entidad Orden y le asignamos un número aleatorio de orden.
        Orden orden = new Orden();
        orden.setNumOrden(UUID.randomUUID().toString());

        //Mapeamos la lista del DTO y la convertimos en una lista de Entidad.
        List<LineaOrden> lineasOrden =  solicitud.getLineasOrdenDto()
                .stream()
                .map(this::mapALineaOrden)
                .toList();

        orden.setLineasPedido(lineasOrden);

        //Guardamos en la DB
        repoOrden.save(orden);
    }

    /**
     * Convierte un DTO de {@link LineaOrdenDto} a una Entidad {@link LineaOrden}
     * @param lineaOrdenDto Dto a convertir.
     * @return Objeto {@link LineaOrden} correspondiente.
     */
    private LineaOrden mapALineaOrden(LineaOrdenDto lineaOrdenDto) {
        LineaOrden lOrden = new LineaOrden();
        lOrden.setSku(lineaOrdenDto.getSku());
        lOrden.setCantidad(lineaOrdenDto.getCantidad());
        lOrden.setPrecio(lineaOrdenDto.getPrecio());

        return lOrden;
    }
}
