package org.example;

import org.example.entidades.Producto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
// Crear productos, algunos con códigos repetidos
        Producto p1 = new Producto("A101", "Laptop HP", 950.0);
        Producto p2 = new Producto("B202", "Mouse", 25.0);
        Producto p3 = new Producto("C303", "Teclado Mecánico", 75.0);
        Producto p4 = new Producto("A101", "Laptop Dell", 1100.0); // Mismo código que p1
        Producto p5 = new Producto("B202", "Mouse Bluetooth", 30.0); // Mismo código que p2

        // Crear un HashSet para almacenar los productos
        Set<Producto> catalogoProductos = new HashSet<>();

        // Agregar los productos al HashSet
        catalogoProductos.add(p1);
        catalogoProductos.add(p2);
        catalogoProductos.add(p3);
        System.out.println("Tamaño del catálogo después de agregar 3 productos únicos: " + catalogoProductos.size());

        // Intentar agregar productos con códigos duplicados
        System.out.println("\nIntentando agregar productos duplicados...");
        boolean added4 = catalogoProductos.add(p4);
        boolean added5 = catalogoProductos.add(p5);

        System.out.println("¿Se agregó el producto 4 (Laptop Dell)? " + added4);
        System.out.println("¿Se agregó el producto 5 (Mouse Bluetooth)? " + added5);

        System.out.println("\nContenido final del catálogo:");
        for (Producto p : catalogoProductos) {
            System.out.println(p);
        }

        System.out.println("\nTamaño final del catálogo: " + catalogoProductos.size());
    }
}