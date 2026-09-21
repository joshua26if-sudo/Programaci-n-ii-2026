/**
 * @author [Joshua-Israel-Flores-Pérez]
 * @carnet [9941-25-9403]
 */
public abstract class Vehiculo {
    private String placa;
    private String propietario;
    private String horaIngreso;
    private int horasUtilizadas;

    public Vehiculo(String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        this.placa = placa;
        this.propietario = propietario;
        this.horaIngreso = horaIngreso;
        this.horasUtilizadas = horasUtilizadas;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public int getHorasUtilizadas() {
        return horasUtilizadas;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setHorasUtilizadas(int horasUtilizadas) {
        this.horasUtilizadas = horasUtilizadas;
    }

    public abstract double calcularCosto();

    public abstract String getTipo();

    public void mostrarInformacion() {
        System.out.println("Placa: " + placa);
        System.out.println("Propietario: " + propietario);
        System.out.println("Tipo: " + getTipo());
        System.out.println("Hora de ingreso: " + horaIngreso);
        System.out.println("Horas utilizadas: " + horasUtilizadas);
        System.out.println("Costo: Q" + String.format("%.2f", calcularCosto()));
    }
}