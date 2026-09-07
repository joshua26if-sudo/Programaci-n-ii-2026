import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("===SISTEMA VETERINARIO VETCARE===");

        //ArrayList
        ArrayList<Mascota> mascotas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        mascotas.add(new Perro(
                "VET-001",
                "Luna",
                14,
                12.5,
                "Mestiza"));

        mascotas.add(new Gato(
                "VET-002",
                "Milo",
                24,
                4.8,
                true));

        mascotas.add(new Ave(
                "VET-003",
                "Piolín",
                10,
                0.4,
                "Canario"));

        mascotas.add(new Perro(
                "VET-004",
                "Astro",
                12,
                13.5,
                "Pastor Aleman"));

        System.out.println("\n===CANTIDAD DE PACIENTES===");
        System.out.println("Los pacientes registrados: " + mascotas.size());

        System.out.println("\n===PACIENTES REGISTRADOS===");

        for (Mascota paciente : mascotas) {
            System.out.println("\n-----------------------");
            System.out.println(paciente.mostrarInformacion());

            paciente.emitirSonido();
            double costo = paciente.calcularCostoConsulta();
            System.out.println("Costo de consulta: Q" + costo);
        }

        System.out.println("===ELIMINACIÓN DE MASCOTAS===");
        System.out.println("Eliminando a: " + mascotas.get(0).getNombre());
        mascotas.remove(0);

        System.out.println("\n===PACIENTES DESPUÉS DE ELIMINACIÓN===");
        for (Mascota paciente : mascotas) {
            System.out.println("\n-----------------------");
            System.out.println(paciente.mostrarInformacion());
        }

        //HashSet

        System.out.println("\n===REGISTRO DE CODIGOS===");
        HashSet<String> codigosRegistrados = new HashSet<>();

        boolean agregado1 = codigosRegistrados.add("VET-001");
        boolean agregado2 = codigosRegistrados.add("VET-002");
        boolean agregado3 = codigosRegistrados.add("VET-003");

        System.out.println("Códigos registrados inicialmente: " + codigosRegistrados.size());

        System.out.println("\n===INTENTADO REPETID CÓDIGO");
        boolean agregadoDuplicado = codigosRegistrados.add("VET-001");

        if (agregadoDuplicado) {
            System.out.println("Código registrado exitosamente");
        } else {
            System.out.println("El código VET-001 ya pertenece a otro paciente(duplicado detectado)");
        }

        System.out.println("\n===CÓDIGOS ALMACENADOS EN HASHSET===");
        System.out.println("total de códigos únicos: " + codigosRegistrados.size());

        for (String codigo : codigosRegistrados) {
            System.out.println("* " + codigo);
        }

        // HashMap
        System.out.println("\n===REGISTRO DE PACIENTES===");
        HashMap<String, Mascota> mapaPacientes = new HashMap<>();

        mapaPacientes.put("VET-001", new Perro(
                "VET-001",
                "Luna",
                14,
                12.5,
                "Mestiza"
        ));
        mapaPacientes.put("VET-002", new Gato(
                "VET-002",
                "Milo",
                24,
                4.8,
                true
        ));
        mapaPacientes.put("VET-003", new Ave(
                "VET-003",
                "Piolin",
                10,
                0.4,
                "Canario"
        ));

        System.out.println("Pacientes en HashMap: " + mapaPacientes.size());

        System.out.println("\n===BUSCAR CÓDIGO EXISTENTE===");
        String codigoBuscar = "VET-002";
        if (mapaPacientes.containsKey(codigoBuscar)) {
            Mascota encontrada = mapaPacientes.get(codigoBuscar);
            System.out.println("Paciente encontrado: " + encontrada.mostrarInformacion());
        } else {
            System.out.println("Código no encontrado");
        }

        System.out.println("\n===BUSCAR CÓDIGO INEXISTENTE===");
        codigoBuscar = "VET-999";
        if (mapaPacientes.containsKey((codigoBuscar))) {
            Mascota encontrada = mapaPacientes.get(codigoBuscar);
            System.out.println("Paciente encontrado: " + encontrada.mostrarInformacion());
        } else {
            System.out.println("Código VET-999 no encontrado");
        }

        System.out.println("\n===TODOS LOS PACIENTES EN HASHMAP===");
        for (String codigo : mapaPacientes.keySet()) {
            System.out.println(mapaPacientes.get(codigo).mostrarInformacion());
        }

        //==========================================================================
        
        System.out.println("\n===ACTUALIZACIÓN DE PESO===");

        System.out.println("Peso anterior de Luna: " + mascotas.get(0).getPesoKg() + "kg");
        System.out.println("Costo anterior: Q" + mascotas.get(0).calcularCostoConsulta());

        mascotas.get(0).actualizarPeso(30.0);

        System.out.println("\nInformación actualizada:");
        System.out.println(mascotas.get(0).mostrarInformacion());

        System.out.println("Nuevo costo: Q" + mascotas.get(0).calcularCostoConsulta());
    }
}