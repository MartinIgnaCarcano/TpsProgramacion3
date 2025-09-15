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
    }
}