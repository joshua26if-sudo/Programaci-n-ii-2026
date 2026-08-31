/**
 * @author [Joshua-Israel-Flores-Pérez]
 * @carnet [9941-25-9403]
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   SISTEMA DE FIGURAS GEOMÉTRICAS");
        System.out.println("=====================================");
        System.out.println("Estudiante: Joshua Israel Flores Pérez");
        System.out.println("Carné: 9941-25-9403");
        System.out.println("=====================================\n");

        Figura circulo = new Circulo("Círculo", 5.0);
        Figura rectangulo = new Rectangulo("Rectángulo", 8.0, 4.0);
        Figura triangulo = new Triangulo("Triángulo", 6.0, 3.0);

        Figura[] figuras = {circulo, rectangulo, triangulo};

        System.out.println("=====RESULTADOS=====\n");

        for (Figura figura : figuras) {
            System.out.println("Nombre: " + figura.getNombre());

            double area = figura.calcularArea();
            System.out.println("Área: " + String.format("%.2f", area) + " unidades²");
            System.out.println();
        }

        System.out.println("=====INFORMACIÓN DETALLADA=====\n");

        for (Figura figura : figuras) {
            figura.mostrarInformacion();
            System.out.println();
        }

        System.out.println("Programa ejecutado correctamente.");
        System.out.println("Demostración de abstracción, herencia y polimorfismo.");
    }
}