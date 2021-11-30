package com.emergentes.modelo;

/**
 *
 * @author Jhonny
 */
public class Nivel {

    private int id_nivel;
    private String descripcion_niv;
    private String fecha_nive;
    private String estado_niv;
    private int id_seccion_niv;
    private int id_aula_niv;
    private String descripcion_aula;
    private String descripcion_sec;

    public Nivel() {
    }

    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getDescripcion_niv() {
        return descripcion_niv;
    }

    public void setDescripcion_niv(String descripcion_niv) {
        this.descripcion_niv = descripcion_niv;
    }

    public String getFecha_nive() {
        return fecha_nive;
    }

    public void setFecha_nive(String fecha_nive) {
        this.fecha_nive = fecha_nive;
    }

    public String getEstado_niv() {
        return estado_niv;
    }

    public void setEstado_niv(String estado_niv) {
        this.estado_niv = estado_niv;
    }

    public int getId_seccion_niv() {
        return id_seccion_niv;
    }

    public void setId_seccion_niv(int id_seccion_niv) {
        this.id_seccion_niv = id_seccion_niv;
    }

    public int getId_aula_niv() {
        return id_aula_niv;
    }

    public void setId_aula_niv(int id_aula_niv) {
        this.id_aula_niv = id_aula_niv;
    }

    public String getDescripcion_aula() {
        return descripcion_aula;
    }

    public void setDescripcion_aula(String descripcion_aula) {
        this.descripcion_aula = descripcion_aula;
    }

    public String getDescripcion_sec() {
        return descripcion_sec;
    }

    public void setDescripcion_sec(String descripcion_sec) {
        this.descripcion_sec = descripcion_sec;
    }

    @Override
    public String toString() {
        return "Nivel{" + "id_nivel=" + id_nivel + ", descripcion_niv=" + descripcion_niv + ", fecha_nive=" + fecha_nive + ", estado_niv=" + estado_niv + ", id_seccion_niv=" + id_seccion_niv + ", id_aula_niv=" + id_aula_niv + ", descripcion_aula=" + descripcion_aula + ", descripcion_sec=" + descripcion_sec + '}';
    }

   

   
    
}
