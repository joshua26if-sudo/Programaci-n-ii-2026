/**
 * @author [Joshua-Israel-Flores-Pérez]
 * @carnet [9941-25-9403]
 */
public class Automovil extends Vehiculo {
    private static final double TARIFA_HORA = 10.00;

    public Automovil(String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {
        double costo = getHorasUtilizadas() * TARIFA_HORA;
        if (getHorasUtilizadas() > 5) {
            costo = costo * 0.90;
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Automóvil";
    }
}