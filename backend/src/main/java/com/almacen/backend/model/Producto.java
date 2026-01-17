package com.almacen.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos") // Así se llamará la tabla en Postgres
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto hace que el ID sea autoincremental (1, 2, 3...)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    private Double precio;
    private Integer cantidad;

    // --- CONSTRUCTORES ---
    public Producto() {
    }

    public Producto(String nombre, Double precio, Integer cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // --- GETTERS Y SETTERS (Para que Java pueda leer/escribir los datos) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}