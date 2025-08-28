package org.example;

import org.example.entidades.Curso;
import org.example.entidades.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Estudiante estu = new Estudiante("Martin",24,"ingenieria");

        List<Estudiante> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(estu);
        listaAlumnos.add(new Estudiante("Sofía López", 21, "Derecho"));
        listaAlumnos.add(new Estudiante("Javier Fernández", 24, "Ingeniería"));
        listaAlumnos.add(new Estudiante("Ana Díaz", 19, "Medicina"));
        listaAlumnos.add(new Estudiante("Carlos García", 25, "Arquitectura"));
        listaAlumnos.add(new Estudiante("María Rodríguez", 22, "Psicología"));
        listaAlumnos.add(new Estudiante("Pedro Sánchez", 20, "Informática"));
        listaAlumnos.add(new Estudiante("Laura Martínez", 23, "Economía"));
        listaAlumnos.add(new Estudiante("Diego Pérez", 26, "Química"));
        listaAlumnos.add(new Estudiante("Paula Gómez", 18, "Biología"));
        listaAlumnos.add(new Estudiante("Andrés Romero", 27, "Filosofía"));
        listaAlumnos.add(new Estudiante("Elena López", 22, "Ingeniería"));
        listaAlumnos.add(new Estudiante("Luis García", 24, "Derecho"));
        listaAlumnos.add(new Estudiante("Isabel Fernández", 20, "Medicina"));
        listaAlumnos.add(new Estudiante("Martín Rodríguez", 25, "Psicología"));
        listaAlumnos.add(new Estudiante("Carmen Sánchez", 21, "Arquitectura"));
        listaAlumnos.add(new Estudiante("Daniel Díaz", 23, "Informática"));
        listaAlumnos.add(new Estudiante("Lucía Pérez", 19, "Economía"));
        listaAlumnos.add(new Estudiante("Alejandro Gómez", 26, "Química"));
        listaAlumnos.add(new Estudiante("Clara Romero", 22, "Biología"));
        listaAlumnos.add(new Estudiante("Gabriel Martínez", 24, "Filosofía"));
        listaAlumnos.add(new Estudiante("Jimena Sánchez", 20, "Medicina"));
        listaAlumnos.add(new Estudiante("Emilio López", 25, "Ingeniería"));
        listaAlumnos.add(new Estudiante("Silvia Fernández", 21, "Derecho"));
        listaAlumnos.add(new Estudiante("Ricardo Pérez", 23, "Arquitectura"));
        listaAlumnos.add(new Estudiante("Natalia Díaz", 19, "Psicología"));
        listaAlumnos.add(new Estudiante("Jorge Gómez", 26, "Informática"));
        listaAlumnos.add(new Estudiante("Valeria Romero", 22, "Economía"));
        listaAlumnos.add(new Estudiante("Mario Martínez", 24, "Biología"));
        listaAlumnos.add(new Estudiante("Andrea Sánchez", 20, "Química"));
        listaAlumnos.add(new Estudiante("Francisco Rodríguez", 25, "Filosofía"));

        Curso curso = new Curso("Programación 3",listaAlumnos,"Juan Gonzales");
        System.out.println(curso);
    }
}