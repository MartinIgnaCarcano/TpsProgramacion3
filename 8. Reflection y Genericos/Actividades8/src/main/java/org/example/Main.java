package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
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
    }
}