package com.utec.demo.spring_boot.Producto;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(Long id) {
        super("Producto con id " + id + " no econtrado");
    }
}
