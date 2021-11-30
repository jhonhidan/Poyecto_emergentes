package com.emergentes.modelo;

/**
 *
 * @author Jhonny
 */
public class Matricula {

    private int id_matricula;
    private int id_nivel_mat;
    private int id_estudiante;
    private String estado;
    private String fecha_matricula;
    private String nombre_es;
    private String apellidos;
    private String cedula;
    private int edad;
    private String fecha_nacimiento;
    private String descripcion_sec;
    private String año;
    private String descripcion_aula;
    private String descripcion_niv;
    private String foto;

    public Matricula() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public int getId_nivel_mat() {
        return id_nivel_mat;
    }

    public void setId_nivel_mat(int id_nivel_mat) {
        this.id_nivel_mat = id_nivel_mat;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_matricula() {
        return fecha_matricula;
    }

    public void setFecha_matricula(String fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }

    public String getNombre_es() {
        return nombre_es;
    }

    public void setNombre_es(String nombre_es) {
        this.nombre_es = nombre_es;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDescripcion_sec() {
        return descripcion_sec;
    }

    public void setDescripcion_sec(String descripcion_sec) {
        this.descripcion_sec = descripcion_sec;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDescripcion_aula() {
        return descripcion_aula;
    }

    public void setDescripcion_aula(String descripcion_aula) {
        this.descripcion_aula = descripcion_aula;
    }

    public String getDescripcion_niv() {
        return descripcion_niv;
    }

    public void setDescripcion_niv(String descripcion_niv) {
        this.descripcion_niv = descripcion_niv;
    }

    @Override
    public String toString() {
        return "Matricula{" + "id_matricula=" + id_matricula + ", id_nivel_mat=" + id_nivel_mat + ", id_estudiante=" + id_estudiante + ", estado=" + estado + ", fecha_matricula=" + fecha_matricula + ", nombre_es=" + nombre_es + ", apellidos=" + apellidos + ", cedula=" + cedula + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + ", descripcion_sec=" + descripcion_sec + ", a\u00f1o=" + año + ", descripcion_aula=" + descripcion_aula + ", descripcion_niv=" + descripcion_niv + ", foto=" + foto + '}';
    }

   


}
