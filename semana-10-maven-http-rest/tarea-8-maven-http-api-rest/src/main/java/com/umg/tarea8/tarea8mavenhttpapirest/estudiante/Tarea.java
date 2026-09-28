package com.umg.tarea8.tarea8mavenhttpapirest.estudiante;

/**
 * @author [Joshua Israel Flores Pérez]
 * @carnet [9941-25-9403]
 */
public class Tarea {
    private Long id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private boolean completada;

    public Tarea(Long id, String titulo, String descripcion, String prioridad, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public void mostrarInformacion() {
        String estado = completada ? "Completada" : "Pendiente";
        System.out.println(id + " | " + titulo + " | " + prioridad + " | " + estado);
    }
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", completada=" + completada +
                '}';
    }
}