package org.example;
public class Main {
    public static void main(String[] args) {
        System.out.println(new Persona());
        System.out.println(new Persona("Martin",24));
        System.out.println(new Persona("Fer",27));
        System.out.println(new Persona("Seba",15));
        System.out.println(new Persona("Rodri",17));

        Usuario usuario = Usuario.builder()
                .id(123)
                .nombre("Martin")
                .email("martin@prueba.com")
                .build();
        Usuario usuario1 = Usuario.builder()
                .id(132)
                .nombre("Paco")
                .email("paco@prueba.com")
                .build();
        System.out.println(usuario);
        System.out.println(usuario1);
    }
}