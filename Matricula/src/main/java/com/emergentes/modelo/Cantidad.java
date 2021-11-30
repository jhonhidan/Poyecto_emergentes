
package com.emergentes.modelo;

public class Cantidad {
    private int cantid_buscar;

    public Cantidad() {
    }

    public int getCantid_buscar() {
        return cantid_buscar;
    }

    public void setCantid_buscar(int cantid_buscar) {
        this.cantid_buscar = cantid_buscar;
    }

    @Override
    public String toString() {
        return "Cantidad{" + "cantid_buscar=" + cantid_buscar + '}';
    }
    
    
}
