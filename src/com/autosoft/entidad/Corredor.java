package com.autosoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Corredor {
    private String corredor_id;
    private int puesto;
    private Piloto piloto;
    private Auto auto;
    private List<Vuelta> listaDeVueltas;
    private Carrera carrera;

    public Corredor(String corredor_id, Piloto piloto, Auto auto, Carrera carrera) {
        this.corredor_id = corredor_id;
        this.piloto = piloto;
        this.auto = auto;
        this.carrera = carrera;
        listaDeVueltas = new ArrayList<>();
    }

    public String getCorredor_id() {
        return corredor_id;
    }

    public void setCorredor_id(String corredor_id) {
        this.corredor_id = corredor_id;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public Auto getAuto() {
        return auto;
    }

    public List<Vuelta> getListaDeVueltas() {
        return listaDeVueltas;
    }


    // Métodos de clase
    public void correrVuelta (int numeroDeVuelta){
        float velocidadDeVuelta = calcularVelocidadDeVuelta();
        float tiempoDeVuelta = calcularTiempoDeVueltaEnMinutos();
        Vuelta vuelta  = new Vuelta(numeroDeVuelta, velocidadDeVuelta, tiempoDeVuelta);

    }

    private float calcularVelocidadDeVuelta(){
        return auto.calcularVelocidad() * piloto.calcularProbabildadDeExito();
    }

    private float calcularTiempoDeVueltaEnMinutos(){
        return 0;
    }

    public float calcularTiempoDeCarrera(){
        float tiempoDeCarrera = 0;
        for (Vuelta vuelta : listaDeVueltas) {
            tiempoDeCarrera += vuelta.getTiempo();
        }
        return tiempoDeCarrera;
    }

    public float calcularTiempoPromedioDeVuelta(){
        return 0;
    }

    private float calcularSumatoriaDeVarianza(){
        return 0;
    }

    public double calcularVarianzaDelTiempo(){
        return 0;
    }

    public double calcularDesviacionEstandarDelTiempo(){
        return 0;
    }

    public Vuelta obtenerVueltaMasRapida(){
        return  null;
    }

    public Vuelta obtenerVueltaMasLenta(){
        return null;
    }

    private float calcularSumatorioDeVelocidadPorVuelta(){
        return 0;
    }

    public float calcularVelocidadPromedioDeVuelta(){
        return 0;
    }

    public boolean eresGanador(){
        return true;
    }
}
