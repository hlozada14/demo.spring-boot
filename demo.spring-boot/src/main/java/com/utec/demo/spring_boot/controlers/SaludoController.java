package com.utec.demo.spring_boot.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saludo")

public class SaludoController {
    @GetMapping
    public String Saludo()
    {
        return "Hola soy Humberto Lozada";
    }

    @RestController
    @RequestMapping("/api/products")
    public static class ProductoControllerBD {
    }
}
