package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Ana", 8, "Java"),
                new Alumno("Luis", 6, "Python"),
                new Alumno("Maria", 9, "Java"),
                new Alumno("Pedro", 7, "Python"),
                new Alumno("Lucia", 5, "Java"),
                new Alumno("Juan", 10, "Python")
        );

        // 1. Aprobados en mayúsculas y ordenados
        System.out.println("Aprobados:");
        alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .forEach(System.out::println);

        // 2. Promedio general
        double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);
        System.out.println("\nPromedio general: " + promedio);

        // 3. Agrupar por curso
        System.out.println("\nAlumnos agrupados por curso:");
        Map<String, List<Alumno>> agrupados = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        agrupados.forEach((curso, lista) ->
                System.out.println(curso + " -> " + lista)
        );

        // 4. Los 3 mejores promedios
        System.out.println("\nTop 3 mejores alumnos:");
        alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .forEach(System.out::println);


        /*ACTIVADA 3*/
        System.out.println("----------------------------");
        System.out.println("-------- Actividad 3 -------");
        System.out.println("----------------------------");
        List<Producto> productos = Arrays.asList(
                new Producto("Notebook", "Electrónica", 1200, 5),
                new Producto("Celular", "Electrónica", 800, 10),
                new Producto("Silla", "Muebles", 150, 20),
                new Producto("Mesa", "Muebles", 90, 15),
                new Producto("Auriculares", "Electrónica", 50, 30),
                new Producto("Lámpara", "Muebles", 110, 8)
        );
        //1. productos con precio mayor a 100 y ordenados desc.
        productos.stream()
                .filter(p -> p.getPrecio() >= 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .forEach(System.out::println);
        System.out.println();
        //2. Agrupar por categoria y calcular el stock total
        System.out.println("\nStock total por categoría:");
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));
        stockPorCategoria.forEach((cat, stock) ->
                System.out.println(cat + ": " + stock));

        // 3. String con nombre y precio separados por ";"
        String reporte = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("\nReporte: " + reporte);
        // 4. Promedio general y por categoría
        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("\nPromedio general de precios: " + promedioGeneral);

        System.out.println("Promedio por categoría:");
        Map<String, Double> promedioCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        promedioCategoria.forEach((cat, prom) ->
                System.out.println(cat + ": " + prom));
    }
}