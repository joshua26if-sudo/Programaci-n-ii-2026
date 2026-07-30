import java.util.Scanner;
/*
* @author Joshua Israel Flores Pérez
* @carnet 9941-25-9403
*/
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Solicita y almacena datos del usuario
        System.out.print("Ingrese su nombre: ");
        String nombreCompleto = entrada.nextLine();

        System.out.print("Ingrese su carné: ");
        String carnet = entrada.nextLine();

        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = entrada.nextInt();

        System.out.print("Ingrese el año actual: ");
        int anioActual = entrada.nextInt();

        //Calcula la edad aproximada restando los años
        int edadAproximada = anioActual - anioNacimiento;

        int edadEnMeses = edadAproximada * 12;

        boolean esMayorDeEdad = edadAproximada >= 18;

        System.out.println("\n----- RESULTADO -----");
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Carné: " + carnet);
        System.out.println("Edad aproximada: " + edadAproximada + " años");
        System.out.println("Edad aproximada en meses: " + edadEnMeses + " meses");
        System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);

        entrada.close();
    }
}
