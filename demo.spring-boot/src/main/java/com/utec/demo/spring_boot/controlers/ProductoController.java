package com.utec.demo.spring_boot.controlers;

import com.utec.demo.spring_boot.Producto.Producto;
import com.utec.demo.spring_boot.Producto.ProductoDTO;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDto) {
        System.out.println("Producto recibido: " + productoDto.getNombre() + ", Precio: " + productoDto.getPrecio());
        return new Producto(4L, productoDto.getNombre(), productoDto.getPrecio());
    }
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id)
    {
        return new Producto(1L, "Producto A", 20.0);
    }
}
