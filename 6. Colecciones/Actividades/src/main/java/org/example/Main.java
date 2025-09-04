package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Actividad 2");
        System.out.println("------------------------------------");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Juan", 8.5));
        alumnos.add(new Alumno("María", 9.2));
        alumnos.add(new Alumno("Pedro", 7.8));
        alumnos.add(new Alumno("Ana", 6.5));
        alumnos.add(new Alumno("Luis", 9.0));
        alumnos.add(new Alumno("Sofía", 8.9));
        alumnos.add(new Alumno("Carlos", 7.1));

        // Recorrer la lista e imprimir la información de cada alumno
        System.out.println("Lista de alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }

        System.out.println("------------------------------------");
        System.out.println("Actividad 3");
        System.out.println("------------------------------------");
        Set<Producto>productos = new HashSet<>();
        productos.add(new Producto(12345678,"descripcion1"));
        productos.add(new Producto(12345679,"descripcion2"));
        productos.add(new Producto(12345610,"descripcion3"));
        productos.add(new Producto(12345678,"descripcion1"));//repetido
        productos.add(new Producto(12345679,"descripcion2"));//repetido
        productos.add(new Producto(12345611,"descripcion4"));

        for (Producto producto: productos){
            System.out.println(producto);
        }
        System.out.println("------------------------------------");
        System.out.println("Actividad 4");
        System.out.println("------------------------------------");
        Map<String, Curso> cursos = new HashMap<>();
        cursos.put("P3",new Curso("Prog3","Alvaro Gonzales"));
        cursos.put("P2",new Curso("Prog2","Alvaro Perez"));
        cursos.put("P1",new Curso("Prog1","Alvaro Garcia"));
        cursos.put("P0",new Curso("Prog0","Alvaro Martinez"));

        System.out.println(cursos.get("P3"));
        System.out.println(cursos.get("P0"));
        for (Map.Entry<String, Curso> entry : cursos.entrySet()) { //
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue()); //
        }

    }

    }
