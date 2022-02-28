package com.autosoft.tabla;

/**
 *
 * @author Lain
 */
public class Columna {
    private String nombre;
    private int ancho;

    public Columna(String nombre, int ancho) {
        this.nombre = nombre;
        this.ancho = ancho;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAncho() {
        return ancho;
    }
    
}
