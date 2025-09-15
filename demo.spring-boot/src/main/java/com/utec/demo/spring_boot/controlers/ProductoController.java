package com.utec.demo.spring_boot.controlers;

import com.utec.demo.spring_boot.Producto.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")

public class ProductoController {
    @GetMapping
    public List<Producto> listarProductos()
    {
        return List.of (
                new Producto(1L, "Producto A", 20.0),
                new Producto(2L, "Producto B", 30.0),
                new Producto(3L, "Producto C", 40.0)
        );
    }
}
