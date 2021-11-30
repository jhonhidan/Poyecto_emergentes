
package com.emergentes.modelo;

public class Usuarios {

    private int id_usuario;
    private int id_rol_usu;
   
    private String usuario;
    private String password;
    private String estado_usu;
    private int id_estudiante_usu;
    private String descripcion_rol;
    private String nombre_es_usu;
    private String apellido_es_usu;

    public Usuarios() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol_usu() {
        return id_rol_usu;
    }

    public void setId_rol_usu(int id_rol_usu) {
        this.id_rol_usu = id_rol_usu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado_usu() {
        return estado_usu;
    }

    public void setEstado_usu(String estado_usu) {
        this.estado_usu = estado_usu;
    }

    public int getId_estudiante_usu() {
        return id_estudiante_usu;
    }

    public void setId_estudiante_usu(int id_estudiante_usu) {
        this.id_estudiante_usu = id_estudiante_usu;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }

    public String getNombre_es_usu() {
        return nombre_es_usu;
    }

    public void setNombre_es_usu(String nombre_es_usu) {
        this.nombre_es_usu = nombre_es_usu;
    }

    public String getApellido_es_usu() {
        return apellido_es_usu;
    }

    public void setApellido_es_usu(String apellido_es_usu) {
        this.apellido_es_usu = apellido_es_usu;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id_usuario=" + id_usuario + ", id_rol_usu=" + id_rol_usu + ", usuario=" + usuario + ", password=" + password + ", estado_usu=" + estado_usu + ", id_estudiante_usu=" + id_estudiante_usu + ", descripcion_rol=" + descripcion_rol + ", nombre_es_usu=" + nombre_es_usu + ", apellido_es_usu=" + apellido_es_usu + '}';
    }

   
    

}
