package org.example;

import org.example.entidades.Producto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();

        Producto p1 = new Producto("A101", "Laptop HP", 950.0);
        Producto p2 = new Producto("B202", "Mouse Inalámbrico", 25.0);
        Producto p3 = new Producto("A101", "Laptop Dell", 1000.0);

        listaProductos.add(p1);

        if (!listaProductos.contains(p2)) {
            listaProductos.add(p2);
        }

        if (!listaProductos.contains(p3)) {
            listaProductos.add(p3);
        }

        System.out.println("\nContenido final de la lista:");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }
}