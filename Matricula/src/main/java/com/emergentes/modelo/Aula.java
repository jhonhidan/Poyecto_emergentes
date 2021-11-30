package com.emergentes.modelo;

/**
 *
 * @author Jhonny
 */
public class Aula {

    private int id_aula;
    private String descripcion_aula;
    private String estado_aula;
    private int cantidad_total;

    public Aula() {
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public String getDescripcion_aula() {
        return descripcion_aula;
    }

    public void setDescripcion_aula(String descripcion_aula) {
        this.descripcion_aula = descripcion_aula;
    }

    public String getEstado_aula() {
        return estado_aula;
    }

    public void setEstado_aula(String estado_aula) {
        this.estado_aula = estado_aula;
    }

    @Override
    public String toString() {
        return "Aula{" + "id_aula=" + id_aula + ", descripcion_aula=" + descripcion_aula + ", estado_aula=" + estado_aula + ", cantidad_total=" + cantidad_total + '}';
    }

    
   
    
    
}
