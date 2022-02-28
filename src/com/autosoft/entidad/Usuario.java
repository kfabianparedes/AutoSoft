package com.autosoft.entidad;

public class Usuario {
    private static Usuario usuario;
    private String nombre;
    private double premioAcumulado;
    private int carrerasGanadas;
    private int carrerasJugadas;
    private Corredor corredor;

    private Usuario() {
        premioAcumulado = 0;
        carrerasGanadas = 0;
        carrerasJugadas = 0;
    }

    public static Usuario obtenerInstancia() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPremioAcumulado() {
        return premioAcumulado;
    }

    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }

    public int getCarrerasJugadas() {
        return carrerasJugadas;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    // reglas de negocio

    public void ganarPremio(double premio) {
        premioAcumulado += premio;
        carrerasGanadas++;
    }

    public void incrementarCarrerasJugadas() {
        carrerasJugadas++;
    }

    public boolean eresGanador() {
        return corredor.eresGanador();
    }

}
