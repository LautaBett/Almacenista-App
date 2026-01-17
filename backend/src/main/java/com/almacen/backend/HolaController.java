package com.almacen.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/hola")
    public String saludar() {
        return "¡Hola! El backend del Almacén está funcionando con PostgreSQL 🚀 y editando en visual🙈";
    }
}
