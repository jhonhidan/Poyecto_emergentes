package com.emergentes.modelo;

import java.sql.Date;



/**
 *
 * @author Jhonny
 */
public class Lectivo {

    private int id_añolectivo;
    private String año_inicio;
    private String año_fin;
    private String estado_año;
    private String año;

    public Lectivo() {
    }

    public int getId_añolectivo() {
        return id_añolectivo;
    }

    public void setId_añolectivo(int id_añolectivo) {
        this.id_añolectivo = id_añolectivo;
    }

    public String getAño_inicio() {
        return año_inicio;
    }

    public void setAño_inicio(String año_inicio) {
        this.año_inicio = año_inicio;
    }

    public String getAño_fin() {
        return año_fin;
    }

    public void setAño_fin(String año_fin) {
        this.año_fin = año_fin;
    }

    public String getEstado_año() {
        return estado_año;
    }

    
    public void setEstado_año(String estado_año) {
        this.estado_año = estado_año;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

   @Override
    public String toString() {
        return "Lectivo{" + "id_a\u00f1olectivo=" + id_añolectivo + ", a\u00f1o_inicio=" + año_inicio + ", a\u00f1o_fin=" + año_fin + ", estado_a\u00f1o=" + estado_año + ", a\u00f1o=" + año + '}';
    }

    
}
