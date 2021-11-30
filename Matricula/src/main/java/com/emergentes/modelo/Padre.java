
package com.emergentes.modelo;

/**
 *
 * @author Jhonny
 */
public class Padre {

    private int id_padre;
    private String nombre;
    private String telefono;
    private String direcion;

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }
    
    @Override
    public String toString() {
        return "Padre{" + "id_padre=" + id_padre + ", nombre=" + nombre + ", telefono=" + telefono + ", direcion=" + direcion + '}';
    }


}
