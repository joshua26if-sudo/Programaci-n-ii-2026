import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author [Joshua-Israel-Flores-Pérez]
 * @carnet [9941-25-9403]
 */

public class MainControlCompras {
    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Producto> productos = new ArrayList<>();
    private static HashSet<String> categorias = new HashSet<>();
    private static HashMap<String, Double> totalPorCategoria = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("     CONTROL DE COMPRAS DEL HOGAR");
        System.out.println("=====================================");
        System.out.println("Estudiante: [Tu Nombre Completo]");
        System.out.println("Carné: [9941-25-9403]");
        System.out.println("=====================================\n");

        registrarProductos();

        mostrarResumen();

        consultarCategoria();

        System.out.println("\n¡Programa finalizado correctamente!");
        scanner.close();
    }

    public static void registrarProductos() {
        System.out.println("--- REGISTRO DE PRODUCTOS ---");
        System.out.println("Registre al menos 5 productos válidos.\n");

        int productosRegistrados = 0;
        int intentos = 0;

        while (productosRegistrados < 5) {
            intentos++;
            System.out.println("Producto #" + (productosRegistrados + 1) + " (Intento " + intentos + ")");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: Q");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (validarProducto(nombre, categoria, precio, cantidad)) {
                Producto producto = new Producto(nombre, categoria, precio, cantidad);
                productos.add(producto);

                categorias.add(categoria);

                double subtotal = producto.calcularSubtotal();
                totalPorCategoria.put(categoria,
                        totalPorCategoria.getOrDefault(categoria, 0.0) + subtotal);

                productosRegistrados++;
                System.out.println("Producto registrado exitosamente.\n");
            } else {
                System.out.println("Producto no registrado: revise los datos ingresados.\n");
            }

            if (productosRegistrados >= 5) {
                System.out.print("¿Desea registrar otro producto? (s/n): ");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                if (!respuesta.equals("s")) {
                    break;
                }
            }
        }

        System.out.println("\nRegistro completado. Productos registrados: " + productosRegistrados);
    }

    public static boolean validarProducto(String nombre, String categoria, double precio, int cantidad) {
        boolean valido = true;

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            valido = false;
        }

        if (categoria.isEmpty()) {
            System.out.println("La categoría no puede estar vacía.");
            valido = false;
        }

        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que cero.");
            valido = false;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            valido = false;
        }

        return valido;
    }

    public static void mostrarResumen() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
            return;
        }

        System.out.println("\n===== RESUMEN DE COMPRAS =====\n");

        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categorias);

        System.out.println("\nTotal por categoría:");
        for (String categoria : categorias) {
            double total = totalPorCategoria.get(categoria);
            System.out.println(categoria + ": Q" + String.format("%.2f", total));
        }

        double totalGeneral = 0.0;
        for (Producto producto : productos) {
            totalGeneral += producto.calcularSubtotal();
        }

        System.out.println("\nProductos registrados: " + productos.size());
        System.out.println("Total general: Q" + String.format("%.2f", totalGeneral));

        Producto mayorGasto = null;
        Producto menorGasto = null;
        double mayor = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;

        for (Producto producto : productos) {
            double subtotal = producto.calcularSubtotal();
            if (subtotal > mayor) {
                mayor = subtotal;
                mayorGasto = producto;
            }
            if (subtotal < menor) {
                menor = subtotal;
                menorGasto = producto;
            }
        }

        System.out.println("\nProducto con mayor gasto:");
        System.out.println(mayorGasto.getNombre() + " - Q" + String.format("%.2f", mayor));

        System.out.println("\nProducto con menor gasto:");
        System.out.println(menorGasto.getNombre() + " - Q" + String.format("%.2f", menor));

        String categoriaMayorGasto = "";
        double mayorGastoCategoria = Double.MIN_VALUE;

        for (String categoria : categorias) {
            double total = totalPorCategoria.get(categoria);
            if (total > mayorGastoCategoria) {
                mayorGastoCategoria = total;
                categoriaMayorGasto = categoria;
            }
        }

        System.out.println("\nCategoría con mayor gasto:");
        System.out.println(categoriaMayorGasto + " - Q" + String.format("%.2f", mayorGastoCategoria));
    }

    public static void consultarCategoria() {
        System.out.println("\n--- CONSULTA DE CATEGORÍA ---");
        System.out.print("Ingrese una categoría para consultar: ");
        String categoriaBuscar = scanner.nextLine().trim();

        if (totalPorCategoria.containsKey(categoriaBuscar)) {
            double total = totalPorCategoria.get(categoriaBuscar);
            System.out.println("Total gastado en " + categoriaBuscar + ": Q" +
                    String.format("%.2f", total));
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }
    }
}