package com.umg.tarea8.tarea8mavenhttpapirest.estudiante;

import java.util.ArrayList;

/**
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   CONTROL DE TAREAS PERSONALES");
        System.out.println("=====================================");
        System.out.println("Estudiante: Joshua Israel Flores Pérez");
        System.out.println("Carné: 9941-25-9403");
        System.out.println("=====================================\n");

        // Crear el ArrayList para almacenar las tareas
        ArrayList<Tarea> tareas = new ArrayList<>();

        // Crear al menos 3 objetos de tipo Tarea
        tareas.add(new Tarea(1L, "Comprar alimentos",
                "Comprar productos para la semana", "ALTA", false));

        tareas.add(new Tarea(2L, "Realizar ejercicios",
                "Rutina de ejercicio diario", "MEDIA", true));

        tareas.add(new Tarea(3L, "Estudiar Programación II",
                "Repasar Maven, HTTP y REST", "ALTA", false));

        tareas.add(new Tarea(4L, "Llamar al banco",
                "Consultar estado de cuenta", "BAJA", true));

        // Mostrar el listado de tareas
        System.out.println("===== LISTADO DE TAREAS =====\n");

        for (Tarea tarea : tareas) {
            tarea.mostrarInformacion();
        }

        // Contar tareas pendientes y completadas
        int pendientes = 0;
        int completadas = 0;

        for (Tarea tarea : tareas) {
            if (tarea.isCompletada()) {
                completadas++;
            } else {
                pendientes++;
            }
        }

        System.out.println("\nTareas pendientes: " + pendientes);
        System.out.println("Tareas completadas: " + completadas);
        System.out.println("\nTotal de tareas: " + tareas.size());
    }
}