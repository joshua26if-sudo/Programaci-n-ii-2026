public class Main {

    public static void main(String[] args) {

        Mascota mascota1 = new Perro(
                "VET-001",
                "Luna",
                14,
                12.5,
                "Mestiza");

        Mascota mascota2 = new Gato(
                "VET-002"
                "Milo",
                24,
                4.8,
                true);

        System.out.println(
                mascota1.mostrarInformacion());

        mascota1.emitirSonido();

        System.out.println();

        System.out.println(
                mascota2.mostrarInformacion());

        mascota2.emitirSonido();

        System.out.println();

        mascota1.actualizarPeso(-10);

        Mascota mascota3 = new Ave(
                "VET-003"
                "Piolín",
                10,
                0.4,
                "Canario");

        System.out.println(
                mascota3.mostrarInformacion());

        mascota3.emitirSonido();
    }
}