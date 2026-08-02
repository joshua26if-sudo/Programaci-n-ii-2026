import java.util.Scanner;

/*
* @author Joshua Israel Flores Pérez
* @carnet 9941-25-9403
* */

public class PresupuestoSemanal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su presupuesto semanal: Q");
        double presupuesto = scanner.nextDouble();

        System.out.print("Ingrese su gasto en alimentación: Q");
        double gastoAlimentacion = scanner.nextDouble();

        System.out.print("Ingrese su gasto en trasnporte: Q");
        double gastoTransporte = scanner.nextDouble();

        System.out.print("Ingrese su gasto en otros: Q");
        double gastoOtros = scanner.nextDouble();

        double totalGastado = calcularTotalGastado(gastoAlimentacion, gastoTransporte, gastoOtros);
        double saldoDisponible = calcularSaldo(presupuesto, totalGastado);
        String estado = determinarEstado(presupuesto, totalGastado);

        mostrarResumen(nombre, presupuesto, totalGastado, saldoDisponible, estado);

        scanner.close();
    }

    public static double calcularTotalGastado(double alimentacion, double transporte, double otros) {
        return alimentacion + transporte + otros;
    }

    public static double calcularSaldo(double presupuesto, double totalGastado) {
        return presupuesto - totalGastado;
    }

    public static String determinarEstado(double presupuesto, double totalGastado) {
        if (totalGastado < presupuesto) {
            return "Dentro del presupuesto";
        } else if (totalGastado == presupuesto) {
            return "Presupuesto agotado";
        } else {
            return "Excedió el presupuesto";
        }
    }

    public static void mostrarResumen(String nombre, double presupuesto,
                                      double totalGastado, double saldo, String estado) {
        System.out.println("\nRESUMEN SEMANAL");
        System.out.println("Nombre: " + nombre);
        System.out.println("Presupuesto: Q%." + presupuesto);
        System.out.println("Total gastado: Q% " + totalGastado);
        System.out.println("Saldo: Q% " + saldo);
        System.out.println("Estado: " + estado);
    }
}
