package com.almacen.backend.controller;
 //Este es el código que nos dejará agregar productos desde el navegador.
import com.almacen.backend.model.Producto;
import com.almacen.backend.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos") // Todas las rutas empezarán con /productos
@CrossOrigin(origins = "*") // Permite que cualquier frontend (React, Angular, etc.) pueda acceder
public class ProductoController {

    private final ProductoRepository repositorio;

    // Inyectamos el repositorio para poder usarlo
    public ProductoController(ProductoRepository repositorio) {
        this.repositorio = repositorio;
    }

    // GET: Para ver todos los productos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return repositorio.findAll();
    }

    // POST: Para guardar un producto nuevo
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto nuevoProducto) {
        return repositorio.save(nuevoProducto);
    }
    // --- EDITAR PRODUCTO (PUT) ---
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        // 1. Buscamos el producto en la base de datos por su ID
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 2. Actualizamos los datos con lo que nos mandan
        producto.setNombre(productoDetalles.getNombre());
        producto.setPrecio(productoDetalles.getPrecio());
        producto.setCantidad(productoDetalles.getCantidad());

        // 3. Guardamos los cambios (esto hace el UPDATE en Postgres)
        return repositorio.save(producto);
    }

    // --- BORRAR PRODUCTO (DELETE) ---
    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id) {
        // 1. Buscamos si existe (para que no de error si ya lo borraste)
        if (!repositorio.existsById(id)) {
            return "El producto no existe, no se puede borrar.";
        }
        
        // 2. Lo borramos
        repositorio.deleteById(id);
        return "Producto eliminado con éxito";
    }
    
}