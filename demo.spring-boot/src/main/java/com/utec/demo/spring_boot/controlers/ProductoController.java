package com.utec.demo.spring_boot.controlers;

import com.utec.demo.spring_boot.Producto.Producto;
import com.utec.demo.spring_boot.Producto.ProductoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    @GetMapping
    public List<Producto> listarProductos()
    {
        return BD;
    }
    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDto) {
        Producto nuevoProducto = new Producto(
                                    NEXT_ID.getAndIncrement(),
                                    productoDto.getNombre(),
                                    productoDto.getPrecio());
        BD.add(nuevoProducto);
        return nuevoProducto;
    }
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id)
    {
        return BD.stream()
                        .filter(p -> p.getId().
                        equals(id))
                        .findFirst()
                        .orElse(null);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id)
    {
       Boolean notaEliminada = BD.removeIf(p -> p.getId().equals(id));
        if (notaEliminada)
        {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
}
