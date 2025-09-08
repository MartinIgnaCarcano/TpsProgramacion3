package org.example;

public record ProductoRecord(String codigo, String nombre, double precio) {

    public static ProductoRecord fromProducto(Producto producto) {
        return new ProductoRecord(producto.getCodigo(), producto.getNombre(), producto.getPrecio());
    }
}