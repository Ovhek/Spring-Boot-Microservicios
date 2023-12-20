package com.alexcruceat.ServicioProductos.service;

import com.alexcruceat.ServicioProductos.dto.RespuestaProducto;
import com.alexcruceat.ServicioProductos.dto.SolicitudProducto;
import com.alexcruceat.ServicioProductos.model.Producto;
import com.alexcruceat.ServicioProductos.repository.RepositorioProducto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio sobre los Productos.
 * @Service --> Indicamos que se trata de un servicio.
 * @RequireArgsContructor --> Anotación para generar un constructor con los argumentos requeridos.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioProducto {

    //Inyectamos el repositorio.
    private final RepositorioProducto repositorioProducto;


    /**
     * Crea el producto solicitu
     * @param solicitudProducto
     */
    public void crearProducto(SolicitudProducto solicitudProducto){

        //Creamos el producto según la solicitud.
        Producto producto = Producto.builder()
                .nombre(solicitudProducto.getNombre())
                .descripcion(solicitudProducto.getDescripcion())
                .precio(solicitudProducto.getPrecio())
                .build();

        //Guardamos el producto en la DB
        repositorioProducto.save(producto);

        //Logging de guardado.
        log.info("Producto ID={} Guardado. Fecha={}",producto.getId(),LocalDateTime.now());
    }


    /**
     * Función encargada de obtener los productos de la base de datos.
     * Trans Obtener los productos convierte la Lista obtenida en una Lista del DTO {@link RespuestaProducto}
     * @return Lista de Productos como Lista de {@link RespuestaProducto}
     */
    public List<RespuestaProducto> obtenerProductos() {
        List<Producto> productos =  repositorioProducto.findAll();

        return productos.stream().map(this::mapARespuestaProducto).toList();
    }

    /**
     * Función encargada de Convertir la Entidad Producto a RespuestaProducto.
     * @param producto Entidad a convertir.
     * @return objeto de tipo RespuestaProducto.
     */
    private RespuestaProducto mapARespuestaProducto(Producto producto) {
        return RespuestaProducto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .build();
    }
}
