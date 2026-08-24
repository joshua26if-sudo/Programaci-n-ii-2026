import java.util.Scanner;

/**
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("       SISTEMA DE ENVÍOS");
        System.out.println("=====================================");
        System.out.println("Estudiante: Joshua Israel Flores");
        System.out.println("Carné: 9941-25-9403");
        System.out.println("=====================================\n");

        int opcion;

        do {
            System.out.println("SISTEMA DE ENVÍOS");
            System.out.println("1. Registrar envío nacional");
            System.out.println("2. Registrar envío internacional");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Error: Ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.println();

            switch (opcion) {
                case 1:
                    registrarEnvioNacional();
                    break;
                case 2:
                    registrarEnvioInternacional();
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el Sistema de Envíos!");
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione 1, 2 o 3.");
            }

            System.out.println();

        } while (opcion != 3);

        scanner.close();
    }

    public static void registrarEnvioNacional() {
        System.out.println("--- REGISTRO DE ENVÍO NACIONAL ---");

        String codigo = solicitarTexto("Código del envío: ");
        String destinatario = solicitarTexto("Nombre del destinatario: ");
        double peso = solicitarDouble("Peso del paquete (kg): ", 0, Double.MAX_VALUE);

        String departamento = solicitarTexto("Departamento de destino: ");
        double distancia = solicitarDouble("Distancia (km): ", 0, Double.MAX_VALUE);

        Envio envio = new EnvioNacional(codigo, destinatario, peso, departamento, distancia);

        envio.mostrarResumen(true);

        System.out.println("\nEnvío nacional registrado exitosamente.");
        System.out.print("¿Desea registrar otro envío? (s/n): ");
        String continuar = scanner.nextLine();
        if (continuar.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0);
        }
    }

    public static void registrarEnvioInternacional() {
        System.out.println("--- REGISTRO DE ENVÍO INTERNACIONAL ---");

        String codigo = solicitarTexto("Código del envío: ");
        String destinatario = solicitarTexto("Nombre del destinatario: ");
        double peso = solicitarDouble("Peso del paquete (kg): ", 0, Double.MAX_VALUE);

        String paisDestino = solicitarTexto("País de destino: ");

        Envio envio = new EnvioInternacional(codigo, destinatario, peso, paisDestino);

        envio.mostrarResumen(true);

        System.out.println("\nEnvío internacional registrado exitosamente.");
        System.out.print("¿Desea registrar otro envío? (s/n): ");
        String continuar = scanner.nextLine();
        if (continuar.equalsIgnoreCase("n")) {
            System.out.println("Saliendo del sistema...");
            System.exit(0);
        }
    }

    public static String solicitarTexto(String mensaje) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El campo no puede estar vacío. Intente nuevamente.");
        }
    }

    public static double solicitarDouble(String mensaje, double min, double max) {
        double numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                scanner.nextLine();
                if (numero > min && numero < max) {
                    return numero;
                }
                System.out.println("El valor debe ser mayor que " + min + ". Intente nuevamente.");
            } else {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
        }
    }
}
