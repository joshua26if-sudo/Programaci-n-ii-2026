package com.estudiante.controldespensaapi.model;

/**
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 */
public class ResumenInventario {
    private int cantidadProductos;
    private int totalUnidades;
    private double valorTotal;

    public ResumenInventario(int cantidadProductos, int totalUnidades, double valorTotal) {
        this.cantidadProductos = cantidadProductos;
        this.totalUnidades = totalUnidades;
        this.valorTotal = valorTotal;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public int getTotalUnidades() {
        return totalUnidades;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}