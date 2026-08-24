/**
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 */
public class EnvioInternacional extends Envio {
    private String paisDestino;
    private static final double CARGO_GESTION = 75.00;
    private static final double RECARGO_PORCENTAJE = 0.12; // 12%

    public EnvioInternacional(String codigo, String destinatario, double peso,
                              String paisDestino) {
        super(codigo, destinatario, peso);
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    @Override
    public double calcularCostoFinal() {
        double costoBase = calcularCostoBase();
        double recargo = costoBase * RECARGO_PORCENTAJE;
        return costoBase + CARGO_GESTION + recargo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN ENVÍO INTERNACIONAL =====");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Peso: " + getPeso() + " kg");
        System.out.println("País de destino: " + paisDestino);
        System.out.println("Costo final: Q" + String.format("%.2f", calcularCostoFinal()));
    }

    @Override
    public void mostrarResumen(boolean mostrarDesglose) {
        if (!mostrarDesglose) {
            mostrarResumen();
            return;
        }

        double costoBase = calcularCostoBase();
        double recargo = costoBase * RECARGO_PORCENTAJE;

        System.out.println("\n--- RESUMEN ENVÍO INTERNACIONAL (DESGLOSE) ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Peso: " + getPeso() + " kg");
        System.out.println("País de destino: " + paisDestino);
        System.out.println("Costo base: Q" + String.format("%.2f", costoBase));
        System.out.println("Cargo fijo internacional: Q" + String.format("%.2f", CARGO_GESTION));
        System.out.println("Recargo del 12%: Q" + String.format("%.2f", recargo));
        System.out.println("Costo final: Q" + String.format("%.2f", calcularCostoFinal()));
    }
}
