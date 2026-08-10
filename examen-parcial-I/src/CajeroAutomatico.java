import java.util.Scanner;

/**
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 * Curso: Programación II
 */
public class CajeroAutomatico {

    // Constantes del sistema
    private static final int PIN_CORRECTO = 2026;
    private static final double COMISION_RETIRO = 10.00;
    private static final int MAX_INTENTOS = 3;
    private static final double LIMITE_DEPOSITO = 5000.00;
    private static final double LIMITE_RETIRO = 2000.00;

    // Variables de la cuenta
    private static String titular = "Joshua Israel Flores Pérez";
    private static String numeroCuenta = "9403";
    private static double saldo = 1000.00;

    // Contadores y acumuladores de la sesión
    private static int depositosExitosos = 0;
    private static double totalDepositado = 0.0;
    private static int retirosExitosos = 0;
    private static double totalEntregado = 0.0;
    private static double totalComisiones = 0.0;
    private static int operacionesRechazadas = 0;
    private static int opcionesInvalidas = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("BANCO PROGRESO - CAJERO AUTOMÁTICO");
        System.out.println("=====================================\n");

        // Control de acceso
        if (!validarAcceso()) {
            System.out.println("\n*** CUENTA BLOQUEADA ***");
            System.out.println("Ha superado el número máximo de intentos.");
            System.out.println("Programa finalizado.");
            scanner.close();
            return;
        }

        System.out.println("\n¡Bienvenido/a " + titular + "!");
        System.out.println("Cuenta: ****-**-" + numeroCuenta);
        System.out.println("Saldo inicial: Q" + String.format("%.2f", saldo));

        // Menú principal
        ejecutarMenu();

        scanner.close();
    }

    // ==================== MÉTODOS DE ACCESO ====================

    public static boolean validarAcceso() {
        int intentos = 0;
        int pinIngresado;

        for (intentos = 0; intentos < MAX_INTENTOS; intentos++) {
            System.out.print("Ingrese su PIN de 4 dígitos: ");
            pinIngresado = scanner.nextInt();

            if (pinIngresado == PIN_CORRECTO) {
                System.out.println("PIN correcto.");
                return true;
            } else {
                int intentosRestantes = MAX_INTENTOS - intentos - 1;
                if (intentosRestantes > 0) {
                    System.out.println("PIN incorrecto. Intentos restantes: " + intentosRestantes);
                } else {
                    System.out.println("PIN incorrecto. Último intento fallido.");
                }
            }
        }
        return false;
    }

    // ==================== MENÚ PRINCIPAL ====================

    public static void ejecutarMenu() {
        int opcion;

        do {
            System.out.println("\n=====================================");
            System.out.println("         MENÚ DE OPERACIONES");
            System.out.println("=====================================");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Realizar retiro normal");
            System.out.println("4. Realizar retiro con comisión");
            System.out.println("5. Mostrar resumen de la sesión");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que la entrada sea un número
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    procesarDeposito();
                    break;
                case 3:
                    procesarRetiroNormal();
                    break;
                case 4:
                    procesarRetiroConComision();
                    break;
                case 5:
                    mostrarResumen();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione una opción del 1 al 6.");
                    opcionesInvalidas++;
                    continue; // Regresa al menú inmediatamente
            }
        } while (opcion != 6);
    }

    // ==================== CONSULTA DE SALDO ====================

    public static void consultarSaldo() {
        System.out.println("\n--- CONSULTA DE SALDO ---");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: ****-**-" + numeroCuenta);
        System.out.println("Saldo disponible: Q" + String.format("%.2f", saldo));
    }

    // ==================== DEPÓSITOS ====================

    public static void procesarDeposito() {
        System.out.println("\n--- DEPÓSITO DE DINERO ---");
        double monto;
        boolean montoValido = false;

        while (!montoValido) {
            System.out.print("Ingrese el monto a depositar (Máx. Q5,000.00): Q");
            monto = scanner.nextDouble();

            if (monto <= 0) {
                System.out.println("El monto debe ser mayor que Q0.00.");
            } else if (monto > LIMITE_DEPOSITO) {
                System.out.println("El monto no puede superar los Q" +
                        String.format("%.2f", LIMITE_DEPOSITO) + " por operación.");
            } else {
                montoValido = true;
                double saldoAnterior = saldo;
                saldo += monto;
                depositosExitosos++;
                totalDepositado += monto;

                System.out.println("\n Depósito exitoso.");
                System.out.println("Monto depositado: Q" + String.format("%.2f", monto));
                System.out.println("Saldo anterior: Q" + String.format("%.2f", saldoAnterior));
                System.out.println("Saldo actualizado: Q" + String.format("%.2f", saldo));
            }
        }
    }

    // ==================== RETIROS CON SOBRECARGA ====================

    public static void procesarRetiroNormal() {
        System.out.println("\n--- RETIRO NORMAL ---");
        System.out.print("Ingrese el monto a retirar (Múltiplo de Q20, Máx. Q2,000): Q");
        double monto = scanner.nextDouble();
        procesarRetiro(monto, false);
    }


    public static void procesarRetiroConComision() {
        System.out.println("\n--- RETIRO CON COMISIÓN ---");
        System.out.println("Comisión por retiro de otra red: Q" + String.format("%.2f", COMISION_RETIRO));
        System.out.print("Ingrese el monto a retirar (Múltiplo de Q20, Máx. Q2,000): Q");
        double monto = scanner.nextDouble();
        procesarRetiro(monto, true);
    }

    public static void procesarRetiro(double monto, boolean conComision) {
        double comision = conComision ? COMISION_RETIRO : 0.0;
        double totalDebitar = monto + comision;

        // Validaciones
        String error = validarRetiro(monto, totalDebitar);
        if (error != null) {
            System.out.println("Retiro rechazado: " + error);
            operacionesRechazadas++;
            return;
        }

        // Procesar retiro exitoso
        double saldoAnterior = saldo;
        saldo -= totalDebitar;
        retirosExitosos++;
        totalEntregado += monto;
        if (conComision) {
            totalComisiones += comision;
        }

        // Mostrar resultados
        System.out.println("\n Retiro exitoso.");
        System.out.println("Monto solicitado: Q" + String.format("%.2f", monto));
        if (conComision) {
            System.out.println("Comisión: Q" + String.format("%.2f", comision));
        }
        System.out.println("Total debitado: Q" + String.format("%.2f", totalDebitar));
        System.out.println("Saldo anterior: Q" + String.format("%.2f", saldoAnterior));
        System.out.println("Saldo actualizado: Q" + String.format("%.2f", saldo));
    }

    public static String validarRetiro(double monto, double totalDebitar) {
        if (monto <= 0) {
            return "El monto debe ser mayor que Q0.00.";
        }
        if (monto % 20 != 0) {
            return "El monto debe ser múltiplo de Q20.00.";
        }
        if (monto > LIMITE_RETIRO) {
            return "El monto no puede superar los Q" +
                    String.format("%.2f", LIMITE_RETIRO) + " por operación.";
        }
        if (totalDebitar > saldo) {
            return "Fondos insuficientes. Saldo disponible: Q" +
                    String.format("%.2f", saldo);
        }
        return null;
    }

    // ==================== RESUMEN Y SALIDA ====================

    public static void mostrarResumen() {
        System.out.println("\n=====================================");
        System.out.println("         RESUMEN DE LA SESIÓN");
        System.out.println("=====================================");
        System.out.println("Titular: " + titular);
        System.out.println("Cuenta: ****-**-" + numeroCuenta);
        System.out.println("\n--- ACTIVIDAD DE LA SESIÓN ---");
        System.out.println("Saldo inicial: Q" + String.format("%.2f", 1000.00));
        System.out.println("Depósitos exitosos: " + depositosExitosos);
        System.out.println("Total depositado: Q" + String.format("%.2f", totalDepositado));
        System.out.println("Retiros exitosos: " + retirosExitosos);
        System.out.println("Total entregado en retiros: Q" + String.format("%.2f", totalEntregado));
        System.out.println("Total cobrado en comisiones: Q" + String.format("%.2f", totalComisiones));
        System.out.println("Operaciones rechazadas: " + operacionesRechazadas);
        System.out.println("Opciones inválidas: " + opcionesInvalidas);
        System.out.println("Saldo actual: Q" + String.format("%.2f", saldo));
        System.out.println("=====================================");
    }

    public static void salir() {
        System.out.println("\n--- FINALIZANDO SESIÓN ---");
        mostrarResumen();
        System.out.println("\n ¡Gracias por usar nuestros servicios!");
        System.out.println("Su dinero está seguro con nosotros.");
        System.out.println("¡Hasta pronto!");
    }
}