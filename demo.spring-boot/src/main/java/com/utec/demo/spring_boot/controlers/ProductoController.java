package com.utec.demo.spring_boot.controlers;

import com.utec.demo.spring_boot.Producto.Producto;
import com.utec.demo.spring_boot.Producto.ProductoDTO;
import com.utec.demo.spring_boot.Producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos()
    {
        return productoService.listar();
    }
    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDto) {
        return productoService.crear(productoDto);
    }
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id)
    {
        return productoService.obtenerPorId(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id)
    {
       Boolean notaEliminada = productoService.eliminar(id);
        if (notaEliminada)
        {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
}
