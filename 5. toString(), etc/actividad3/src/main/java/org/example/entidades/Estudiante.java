package org.example.entidades;

public class Estudiante extends Persona{
    private String carrera;

    public Estudiante(String carrera) {
        this.carrera = carrera;
    }

    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    public Estudiante() {
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
