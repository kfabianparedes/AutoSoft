package com.autosoft.entidad;

public class Vuelta {

    private int numero;
    private float velocidad;
    private float tiempo;

    public Vuelta(int numero, float velocidad, float tiempo) {
        this.numero = numero;
        this.velocidad = velocidad;
        this.tiempo = tiempo;
    }

    public int getNumero() {
        return numero;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getTiempo() {
        return tiempo;
    }
}
