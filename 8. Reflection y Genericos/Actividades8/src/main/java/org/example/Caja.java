package org.example;

public class Caja<T> {
    private T contenido;
    // Constructor
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    // Método para obtener el contenido
    public T getContenido() {
        return contenido;
    }

    // Método para establecer el contenido (opcional, pero útil)
    public void setContenido(T nuevoContenido) {
        this.contenido = nuevoContenido;
    }

    // Método para imprimir el contenido (solo como ejemplo)
    public void mostrarContenido() {
        System.out.println("El contenido de la caja es: " + contenido);
        System.out.println("El tipo del contenido es: " + contenido.getClass().getName());
    }
}
