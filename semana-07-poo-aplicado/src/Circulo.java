public class Circulo extends Figura {
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio > 0) {
            this.radio = radio;
        } else {
            System.out.println("El radio debe ser mayor que cero.");
        }
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Figura: " + getNombre());
        System.out.println("Radio: " + radio + " unidades");
        System.out.println("Área: " + String.format("%.2f", calcularArea()) + " unidades²");
    }
}
