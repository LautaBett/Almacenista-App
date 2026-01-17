package com.almacen.backend.repository;

import com.almacen.backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // ¡Listo! No necesitas escribir más. 
    // Al extender JpaRepository, ya tienes métodos para guardar, borrar y buscar.
}