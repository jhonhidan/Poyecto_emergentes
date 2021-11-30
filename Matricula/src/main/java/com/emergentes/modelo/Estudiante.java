
package com.emergentes.modelo;

/**
 *
 * @author Jhonny
 */
public class Estudiante {

    private int id_estudiante;
    private String nombre_es;
    private String apellido;
    private String cedula;
    private int edad;
    private String fecha_naciemto;
    private String genero;
    private String estado_estu;
    private int id_padre;
    private String foto;
    private String correo_estu;
    private String nombre_padre;
   

    public Estudiante() {
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre_es() {
        return nombre_es;
    }

    public void setNombre_es(String nombre_es) {
        this.nombre_es = nombre_es;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha_naciemto() {
        return fecha_naciemto;
    }

    public void setFecha_naciemto(String fecha_naciemto) {
        this.fecha_naciemto = fecha_naciemto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado_estu() {
        return estado_estu;
    }

    public void setEstado_estu(String estado_estu) {
        this.estado_estu = estado_estu;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo_estu() {
        return correo_estu;
    }

    public void setCorreo_estu(String correo_estu) {
        this.correo_estu = correo_estu;
    }

    public String getNombre_padre() {
        return nombre_padre;
    }

    public void setNombre_padre(String nombre_padre) {
        this.nombre_padre = nombre_padre;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id_estudiante=" + id_estudiante + ", nombre_es=" + nombre_es + ", apellido=" + apellido + ", cedula=" + cedula + ", edad=" + edad + ", fecha_naciemto=" + fecha_naciemto + ", genero=" + genero + ", estado_estu=" + estado_estu + ", id_padre=" + id_padre + ", foto=" + foto + ", correo_estu=" + correo_estu + ", nombre_padre=" + nombre_padre + '}';
    }

    
}
