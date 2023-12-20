package com.alexcruceat.ServicioProductos.repository;

import com.alexcruceat.ServicioProductos.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio de los Productos, Identificados por la ID.
 */
public interface RepositorioProducto extends MongoRepository<Producto,String>  {

}
