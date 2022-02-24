package com.autosoft.entidad;

import java.util.ArrayList;
import java.util.List;

public class Corredor {
    private String corredor_id;
    private int puesto;
    private Piloto piloto;
    private Auto auto;
    private List<Vuelta> listaDeVueltas;

    public Corredor(String corredor_id, Piloto piloto, Auto auto, Carrera carrera) {
        this.corredor_id = corredor_id;
        this.piloto = piloto;
        this.auto = auto;
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
        return calcularTiempoDeCarrera() / listaDeVueltas.size();
    }

    private float calcularSumatoriaDeVarianza(){
        float sumatoriaDeVarianza = 0;
        float tiempoPromedioDeVuelta = calcularTiempoPromedioDeVuelta();
        for ( Vuelta vuelta : listaDeVueltas){
            sumatoriaDeVarianza += Math.pow(vuelta.getTiempo() - tiempoPromedioDeVuelta , 2);
        }
        return sumatoriaDeVarianza;
    }

    public double calcularVarianzaDelTiempo(){
        return calcularSumatoriaDeVarianza() / listaDeVueltas.size();
    }

    public double calcularDesviacionEstandarDelTiempo(){
        return Math.sqrt(calcularVarianzaDelTiempo());
    }

    public Vuelta obtenerVueltaMasRapida() {
        Vuelta vueltaMasRapida = null;
        if(!listaDeVueltas.isEmpty()){
            vueltaMasRapida = listaDeVueltas.get(0);
            for( Vuelta vuelta: listaDeVueltas){
                if(vuelta.getTiempo() < vueltaMasRapida.getTiempo()){
                    vueltaMasRapida = vuelta;
                }
            }
        }
        return  vueltaMasRapida;
    }

    public Vuelta obtenerVueltaMasLenta(){
        Vuelta vueltaMasLenta = null;
        if(!listaDeVueltas.isEmpty()){
            vueltaMasLenta = listaDeVueltas.get(0);
            for( Vuelta vuelta: listaDeVueltas){
                if(vuelta.getTiempo() > vueltaMasLenta.getTiempo()){
                    vueltaMasLenta = vuelta;
                }
            }
        }
        return  vueltaMasLenta;
    }

    private float calcularSumatoriaDeVelocidadPorVuelta(){
        float sumatoriaDeVelocidadPorVuelta = 0;
        for(Vuelta vuelta : listaDeVueltas){
            sumatoriaDeVelocidadPorVuelta += vuelta.getVelocidad();
        }
        return sumatoriaDeVelocidadPorVuelta;
    }

    public float calcularVelocidadPromedioDeVuelta(){
        return calcularSumatoriaDeVelocidadPorVuelta() / listaDeVueltas.size();
    }

    public boolean eresGanador(){
        return true;
    }
}
