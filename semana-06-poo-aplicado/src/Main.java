public class Main {

    public static void main(String[] args) {
        System.out.println("===SISTEMA VETERINARIO VETCARE===");

        Mascota[] pacientes = {
            new Perro(
                "VET-001",
                "Luna",
                14,
                12.5,
                "Mestiza"),

            new Gato(
                "VET-002",
                "Milo",
                24,
                4.8,
                true),

            new Ave(
                "VET-003",
                "Piolín",
                10,
                0.4,
                "Canario")
        };

        System.out.println("\n===PACIENTES REGISTRADOS===");

        for (Mascota paciente : pacientes) {
            System.out.println("\n-----------------------");
            System.out.println(paciente.mostrarInformacion());

            paciente.emitirSonido();
            double costo = paciente.calcularCostoConsulta();
            System.out.println("Costo de consulta: Q" + costo);
        }

        System.out.println("\n===ACTUALIZACIÓN DE PESO===");

        System.out.println("Peso anterior de Luna: " + pacientes[0].getPesoKg() + "kg");
        System.out.println("Costo anterior: Q" + pacientes[0].calcularCostoConsulta());

        pacientes[0].actualizarPeso(30.0);

        System.out.println("\nInformación actualizada:");
        System.out.println(pacientes[0].mostrarInformacion());

        System.out.println("Nuevo costo: Q" + pacientes[0].calcularCostoConsulta());
    }
}