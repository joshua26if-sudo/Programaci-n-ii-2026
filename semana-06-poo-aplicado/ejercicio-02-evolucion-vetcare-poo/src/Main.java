import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        System.out.println("===SISTEMA VETERINARIO VETCARE===");

        ArrayList<Mascota> mascotas = new ArrayList<>();

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

        System.out.println("\n===PACIENTES REGISTRADOS===");

        for (Mascota paciente : mascotas) {
            System.out.println("\n-----------------------");
            System.out.println(paciente.mostrarInformacion());

            paciente.emitirSonido();
            double costo = paciente.calcularCostoConsulta();
            System.out.println("Costo de consulta: Q" + costo);
        }

        System.out.println("\n===ACTUALIZACIÓN DE PESO===");

        System.out.println("Peso anterior de Luna: " + mascotas.get(0).getPesoKg() + "kg");
        System.out.println("Costo anterior: Q" + mascotas.get(0).calcularCostoConsulta());

        mascotas.get(0).actualizarPeso(30.0);

        System.out.println("\nInformación actualizada:");
        System.out.println(mascotas.get(0).mostrarInformacion());

        System.out.println("Nuevo costo: Q" + mascotas.get(0).calcularCostoConsulta());
    }
}