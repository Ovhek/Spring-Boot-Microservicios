package com.alexcruceat.ServicioOrdenes.repository;

import com.alexcruceat.ServicioOrdenes.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de la Orden para comunicarse con la DB.
 */
public interface  RepositorioOrden extends JpaRepository<Orden, Long> {

}
