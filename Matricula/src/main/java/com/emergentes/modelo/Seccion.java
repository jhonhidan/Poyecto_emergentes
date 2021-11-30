package com.emergentes.modelo;

/**
 *
 * @author Jhonny
 */
public class Seccion {

    private int id_seccion;
    private String descripcion_sec;
    private String estado_sec;
    private int id_ano_lectivo;
    private String ano_sec;

    public Seccion() {

    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getDescripcion_sec() {
        return descripcion_sec;
    }

    public void setDescripcion_sec(String descripcion_sec) {
        this.descripcion_sec = descripcion_sec;
    }

    public String getEstado_sec() {
        return estado_sec;
    }

    public void setEstado_sec(String estado_sec) {
        this.estado_sec = estado_sec;
    }

    public int getId_ano_lectivo() {
        return id_ano_lectivo;
    }

    public void setId_ano_lectivo(int id_ano_lectivo) {
        this.id_ano_lectivo = id_ano_lectivo;
    }

    public String getAno_sec() {
        return ano_sec;
    }

    public void setAno_sec(String ano_sec) {
        this.ano_sec = ano_sec;
    }

    @Override
    public String toString() {
        return "Seccion{" + "id_seccion=" + id_seccion + ", descripcion_sec=" + descripcion_sec + ", estado_sec=" + estado_sec + ", id_ano_lectivo=" + id_ano_lectivo + ", ano_sec=" + ano_sec + '}';
    }

}
