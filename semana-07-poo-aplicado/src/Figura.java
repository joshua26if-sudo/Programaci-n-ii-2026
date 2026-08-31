public abstract class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Figura: " + nombre);
        System.out.println("Área: " + String.format("%.2f", calcularArea()) + " unidades²");
    }

    public abstract double calcularArea();
}