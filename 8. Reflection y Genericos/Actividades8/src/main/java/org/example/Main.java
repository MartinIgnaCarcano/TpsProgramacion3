package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //Actividad 2
        try {
            Persona persona = new Persona();
            System.out.println("ok");
            Class<?> personaClass = Class.forName("org.example.Persona");

            System.out.println("--- Constructores de Persona ---");
            Constructor<?>[] constructores = personaClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructores) {
                System.out.println(constructor);
            }
            System.out.println();

            System.out.println("--- Instanciando un objeto con Reflection ---");
            Constructor<?> constructorSinArgs = personaClass.getDeclaredConstructor();
            Object objPersona = constructorSinArgs.newInstance();
            System.out.println("Objeto instanciado (inicialmente): " + objPersona);
            System.out.println();

            System.out.println("--- Modificando el nombre en tiempo de ejecución ---");
            Field nombreModificar = personaClass.getDeclaredField("nombre");
            nombreModificar.setAccessible(true);
            System.out.println("Nombre antes de modificar: " + nombreModificar.get(objPersona));
            nombreModificar.set(objPersona, "Juan Perez");
            System.out.println("Nombre modificado: " + nombreModificar.get(objPersona));
            System.out.println();

            System.out.println("--- Invocando método para mostrar información ---");
            Method toStringMetodo = personaClass.getMethod("toString");
            System.out.println(toStringMetodo.invoke(objPersona));
            System.out.println();

            System.out.println("--- Modificando encapsulamiento de 'saludar()' a private ---");
            Method saludarMethod = personaClass.getDeclaredMethod("Saludar");
            saludarMethod.setAccessible(true);
            saludarMethod.invoke(objPersona);
            saludarMethod.setAccessible(false);

        } catch(Exception e){
            throw e;
        }
        //Actividad 3
        System.out.println("--- Caja de String ---");
        Caja<String> cajaDeTexto = new Caja<>("Caja del string");
        cajaDeTexto.mostrarContenido();
        System.out.println();

        System.out.println("--- Caja de Integer ---");
        Caja<Integer> cajaDeNumero = new Caja<>(12345);
        cajaDeNumero.mostrarContenido();
        System.out.println();

        List listaSinGenericos = new ArrayList();
        listaSinGenericos.add(cajaDeTexto);
        listaSinGenericos.add(cajaDeNumero);

        for (Object objetoCaja: listaSinGenericos){
            System.out.println("Tipo de objeto dentro de la lista: "+objetoCaja.getClass().getName());
            System.out.println();
        }

        //Acttividad 4

        List<Integer> numeros = List.of(10, 20, 30, 40, 50);
        System.out.println("Imprimiendo lista de enteros:");
        imprimirLista(numeros);

        List<String> palabras = List.of("Hola", "Mundo", "Genérico", "Java");
        System.out.println("Imprimiendo lista de Strings:");
        imprimirLista(palabras);

    }


    public static <T> void imprimirLista(List<T> lista) {
        System.out.println("Contenido de la lista:");
        for (T elemento : lista) {
            System.out.println(elemento);
        }
        System.out.println("--------------------");
    }
}