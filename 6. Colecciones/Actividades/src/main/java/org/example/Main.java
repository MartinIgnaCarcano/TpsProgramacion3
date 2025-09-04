package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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
    }

    }
