package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
}
