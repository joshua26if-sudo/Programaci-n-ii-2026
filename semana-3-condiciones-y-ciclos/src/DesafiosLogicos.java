import java.util.Scanner;

/*
* @author Joshua Israel Flores Pérez
* @Carnet 9941-25-9403
* */

public class DesafiosLogicos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Mi información Personal
        System.out.println("===========================================");
        System.out.println("Estudiante: Joshua Israel Flores Pérez");
        System.out.println("Carné: 9941-25-9403");
        System.out.println("Semana 3 - Condiciones y ciclos");
        System.out.println("===========================================\n");

        int opcion;

        do {
            System.out.println("==========DESAFÍOS LÓGICOS==========");
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido: ");
                scanner.next();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            //Procesar la opción seleccionada usando switch
            switch (opcion) {
                case 1:
                    System.out.println("GENERAR UNA SECUENCIA");

                    System.out.println("Número inicial: ");
                    int numInicial = scanner.nextInt();

                    System.out.println("Número final: ");
                    int numFinal = scanner.nextInt();

                    System.out.println("Incremento: ");
                    int incremento = scanner.nextInt();

                    if (incremento <= 0) {
                        System.out.println("Error: El incremento debe ser mayor que cero.");
                    } else if (numFinal <= numInicial) {
                        System.out.println("Error: El número final debe ser mayor que el inicial.");
                    } else {
                        System.out.println("Resultado: ");
                        for (int i = numInicial; i <= numFinal; i += incremento) {
                            System.out.println(i + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("CONTEO REGRESIVO");

                    int numero;
                    while (true) {
                        System.out.println("Ingrese el número inicial (10-50): ");
                        numero = scanner.nextInt();

                        if (numero >= 10 && numero <= 50) {
                            break;
                        } else {
                            System.out.println("Error: El número debe estar entre 10 y 50.");
                        }
                    }

                    System.out.println("Resultado: ");
                    int contador = numero;
                    while (contador >= 0) {
                        System.out.println(contador + "");
                        contador--;
                    }
                    System.out.println("\n¡Despegue!");
                    break;

                case 3:
                    System.out.println("ANALIZAR NÚMEROS");
                    System.out.println("Ingrese números enteros (0 para finalizar):");

                    int positios = 0;
                    int negativos = 0;
                    int sumaValida = 0;
                    int ignorados = 0;
                    int numeroIngresado;

                    while (true) {
                        System.out.println("Ingrese un número: ");
                        numeroIngresado = scanner.nextInt();

                        if (numeroIngresado == 0) {
                            break;
                        }

                        if (numeroIngresado % 5 == 0) {
                            System.out.println("El número " + numeroIngresado +  " fue ignorado.");
                            ignorados++;
                            continue;
                        }

                        if (numeroIngresado > 0) {
                            positios++;
                        } else if (numeroIngresado < 0) {
                            negativos++;
                        }

                        sumaValida += numeroIngresado;
                    }

                    System.out.println("\nResultado:");
                    System.out.println("Positivos: " + positios);
                    System.out.println("Negativos: " + negativos);
                    System.out.println("Suma válida: " + sumaValida);
                    System.out.println("Números ignorados: " + ignorados);
                    break;

                case 4:
                    System.out.println("DIBUJAR UNA PIRÁMIDE");

                    int altura;

                    while (true) {
                        System.out.println("Ingrese la altura (3-10): ");
                        altura = scanner.nextInt();

                        if (altura >= 3 && altura <= 10) {
                            break;
                        } else {
                            System.out.println("Error: La altura debe estar entre 3 y 10.");
                        }
                    }

                    for (int i = 1; i <= altura; i++) {
                        for (int j = 1; j <= altura - i;  j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= (2 * i - 1); k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("VALIDAR PALABRA SECRETA");

                    String palabraIngresada;

                    do {
                        System.out.println("Ingrese la palabra secreta: ");
                        palabraIngresada = scanner.nextLine();

                        if (palabraIngresada.trim().equalsIgnoreCase("Guatemala")) {
                            System.out.println("Palabra correcta.");
                            break;
                        } else {
                            System.out.println("Palabra incorrecta. Intente nuevamente.");
                        }
                    } while (true);
                    break;

                case 6:
                    System.out.println("Programa finalizado correctamente.");
                    break;

                default:
                    System.out.println("Error: opción no válida. Seleccione una opción del 1 al 6.");
                    break;
            }

            System.out.println();
        //Repetir mientras la opción no sea 6
        } while (opcion != 6);

        scanner.close();
    }
}
