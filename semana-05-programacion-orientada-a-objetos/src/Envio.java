/*
* @author [Joshua Israel Flores Pérez]
* @carnet [9941-25-9403]
* */

public class Envio {
    private  String codigo;
    private  String destinatario;
    private  double peso;

    public Envio(String codigo, String destinatario, double peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularCostoBase() {
        return peso * 10.0;
    }

    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    public void mostrarResumen() {
        System.out.println("\n=====RESUMEN DEL ENVIO=====");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Peso: " + peso + "kg");
        System.out.println("Costo final: Q" + String.format("%.2f", calcularCostoFinal()));
    }

    public  void mostrarResumen(boolean mostrarDesglose) {
        if (!mostrarDesglose) {
            mostrarResumen();
            return;
        }

        System.out.println("\n=====RESUMEN DEL ENVÍO (DESGLOSE COMPLETO)======");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Peso: " + peso + "kg");
        System.out.println("Costo base: Q" + String.format("%.2f", calcularCostoBase()));
        System.out.println("Costo final: Q" + String.format("%.2f", calcularCostoFinal()));
    }
}
