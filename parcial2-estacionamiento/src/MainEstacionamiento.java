import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author [Joshua-Israel-Flores-Pérez]
 * @carnet [9941-25-9403]
 * Parcial II - Sistema de Estacionamiento
 */
public class MainEstacionamiento {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static HashSet<String> placas = new HashSet<>();
    private static HashMap<String, Double> totalPorTipo = new HashMap<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   SISTEMA DE ESTACIONAMIENTO");
        System.out.println("=====================================");
        System.out.println("Estudiante: Joshua Israel Flores Pérez");
        System.out.println("Carné: 9941-25-9403");
        System.out.println("Parcial II - Parte Práctica");
        System.out.println("=====================================\n");

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcionMenu();

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    mostrarTodosLosVehiculos();
                    break;
                case 3:
                    buscarVehiculoPorPlaca();
                    break;
                case 4:
                    mostrarVehiculoMayorCosto();
                    break;
                case 5:
                    mostrarTotalGeneral();
                    break;
                case 6:
                    mostrarTotalPorTipo();
                    break;
                case 7:
                    System.out.println("\n¡Gracias por usar el sistema!");
                    System.out.println("Programa finalizado correctamente.");
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione 1-7.");
            }
            System.out.println();
        } while (opcion != 7);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("========= MENÚ PRINCIPAL =========");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Mostrar todos los vehículos");
        System.out.println("3. Buscar vehículo por placa");
        System.out.println("4. Mostrar vehículo con mayor costo");
        System.out.println("5. Mostrar total general recaudado");
        System.out.println("6. Mostrar total por tipo de vehículo");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcionMenu() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero.");
            scanner.nextLine();
            return -1;
        } finally {
            System.out.println("→ Validación de opción completada.\n");
        }
    }

    public static void registrarVehiculo() {
        System.out.println("\n--- REGISTRAR VEHÍCULO ---");
        System.out.println("Tipo de vehículo:");
        System.out.println("1. Automóvil (Q10.00/hora)");
        System.out.println("2. Motocicleta (Q6.00/hora)");
        System.out.print("Seleccione el tipo: ");

        int tipo;
        try {
            tipo = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número.");
            scanner.nextLine();
            return;
        }

        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo de vehículo no válido.");
            return;
        }

        System.out.print("Placa: ");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()) {
            System.out.println("La placa no puede estar vacía.");
            return;
        }

        if (placas.contains(placa.toUpperCase())) {
            System.out.println("Error: La placa " + placa + " ya está registrada.");
            return;
        }

        System.out.print("Nombre del propietario: ");
        String propietario = scanner.nextLine().trim();
        if (propietario.isEmpty()) {
            System.out.println("El propietario no puede estar vacío.");
            return;
        }

        System.out.print("Hora de ingreso (HH:MM): ");
        String horaIngreso = scanner.nextLine().trim();

        int horasUtilizadas;
        try {
            System.out.print("Horas utilizadas: ");
            horasUtilizadas = scanner.nextInt();
            scanner.nextLine();

            if (horasUtilizadas <= 0) {
                System.out.println("Las horas deben ser mayores que cero.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero para las horas.");
            scanner.nextLine();
            return;
        }

        Vehiculo vehiculo;
        if (tipo == 1) {
            vehiculo = new Automovil(placa.toUpperCase(), propietario, horaIngreso, horasUtilizadas);
        } else {
            vehiculo = new Motocicleta(placa.toUpperCase(), propietario, horaIngreso, horasUtilizadas);
        }

        vehiculos.add(vehiculo);
        placas.add(placa.toUpperCase());

        String tipoNombre = vehiculo.getTipo();
        totalPorTipo.put(tipoNombre,
                totalPorTipo.getOrDefault(tipoNombre, 0.0) + vehiculo.calcularCosto());

        System.out.println("\nVehículo registrado exitosamente:");
        vehiculo.mostrarInformacion();
    }

    public static void mostrarTodosLosVehiculos() {
        System.out.println("\n--- VEHÍCULOS REGISTRADOS ---");

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (Vehiculo v : vehiculos) {
            v.mostrarInformacion();
            System.out.println("-------------------------------------");
        }
        System.out.println("Total de vehículos: " + vehiculos.size());
    }

    public static void buscarVehiculoPorPlaca() {
        System.out.println("\n--- BUSCAR VEHÍCULO ---");
        System.out.print("Ingrese la placa a buscar: ");
        String placaBuscar = scanner.nextLine().trim().toUpperCase();

        boolean encontrado = false;
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placaBuscar)) {
                System.out.println("\nVehículo encontrado:");
                v.mostrarInformacion();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún vehículo con la placa " + placaBuscar);
        }
    }

    public static void mostrarVehiculoMayorCosto() {
        System.out.println("\n--- VEHÍCULO CON MAYOR COSTO ---");

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        Vehiculo mayor = vehiculos.get(0);
        for (Vehiculo v : vehiculos) {
            if (v.calcularCosto() > mayor.calcularCosto()) {
                mayor = v;
            }
        }

        System.out.println("El vehículo con mayor costo es:");
        mayor.mostrarInformacion();
    }

    public static void mostrarTotalGeneral() {
        System.out.println("\n--- TOTAL GENERAL RECAUDADO ---");

        double total = 0.0;
        for (Vehiculo v : vehiculos) {
            total += v.calcularCosto();
        }
        System.out.println("Total recaudado: Q" + String.format("%.2f", total));
    }

    public static void mostrarTotalPorTipo() {
        System.out.println("\n--- TOTAL POR TIPO DE VEHÍCULO ---");

        if (totalPorTipo.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (String tipo : totalPorTipo.keySet()) {
            System.out.println(tipo + ": Q" + String.format("%.2f", totalPorTipo.get(tipo)));
        }
    }
}