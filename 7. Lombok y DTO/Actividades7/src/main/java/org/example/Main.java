package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------");
        System.out.println("-----Actividad I-----");
        System.out.println("---------------------");
        System.out.println(new Persona());
        System.out.println(new Persona("Martin",24));
        System.out.println(new Persona("Fer",27));
        System.out.println(new Persona("Seba",15));
        System.out.println(new Persona("Rodri",17));


        System.out.println("---------------------");
        System.out.println("----Actividad II-----");
        System.out.println("---------------------");

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

        System.out.println("---------------------");
        System.out.println("----Actividad III----");
        System.out.println("---------------------");

        Producto producto1 = new Producto("A001", "Libro de Java", 45.50, "Juan Perez");
        Producto producto2 = new Producto("A002", "Audifonos Bluetooth", 120.00, "Maria Lopez");

        ProductoDTO dto1 = new ProductoDTO("B001", "Mochila escolar", 60.75);
        ProductoDTO dto2 = new ProductoDTO("B002", "Mouse Inalámbrico", 25.99);

        ProductoDTO dto3 = new ProductoDTO(null, null, 0.0);
        dto3.setCodigo("B003");
        dto3.setNombre("Teclado mecánico");
        dto3.setPrecio(85.00);

        // Se crea una lista para guardar los objetos ProductoDTO
        List<ProductoDTO> listaDTO = new ArrayList<>();
        listaDTO.add(dto1);
        listaDTO.add(dto2);
        listaDTO.add(dto3);

        System.out.println("\n--- Lista de Objetos ProductoDTO ---");
        for (ProductoDTO dto : listaDTO) {
            System.out.println(dto);
        }

    }
}