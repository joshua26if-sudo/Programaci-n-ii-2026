/*
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 * */
public class EnvioNacional extends Envio{
    private String departamento;
    private double distancia;

    public EnvioNacional(String codigo, String destinatario, double peso,
                         String departamento, double distancia) {
        super(codigo, destinatario, peso);
        this.departamento = departamento;
        this.distancia = distancia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public double calcularCostoFinal() {
        double costoBase = calcularCostoBase();
        double cargoDistacia = distancia * 0.50;
        return costoBase + cargoDistacia;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN ENVIO NACIONAL=====");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Peso: " + getPeso() + " kg");
        System.out.println("Departamento: " + departamento);
        System.out.println("Distancia: " + distancia + "km");
        System.out.println("Costo final: Q" + String.format("%.2f", calcularCostoFinal()));
    }

    @Override
    public  void mostrarResumen(boolean mostrarDesglose) {
        if (!mostrarDesglose) {
            mostrarResumen();
            return;
        }

        double costoBase = calcularCostoBase();
        double cargoDistancia = distancia * 0.50;

        System.out.println("\n=====RESUMEN ENVIO NACIONAL(DESGLOSE)=====");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Peso: " + getPeso() + " kg");
        System.out.println("Departamento: " + departamento);
        System.out.println("Distacia: " + distancia + " km");
        System.out.println("Costo base: Q" + String.format("%.2f", costoBase));
        System.out.println("Cargo por distacia (Q 0.50/km): Q" + String.format("%.2f", cargoDistancia));
        System.out.println("Costo final: Q" + String.format("%.2f", calcularCostoFinal()));
    }
}
