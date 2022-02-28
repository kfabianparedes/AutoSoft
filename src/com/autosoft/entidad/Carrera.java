package com.autosoft.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String carrera_id;
    private LocalDate fecha;
    private int vueltas;
    private double premio;
    private boolean terminada;
    private List<Corredor> listaDeCorredores;
    private Circuito circuito;

    public Carrera(String carrera_id, int vueltas, double premio, Circuito circuito) {
        this.carrera_id = carrera_id;
        this.vueltas = vueltas;
        this.premio = premio;
        this.circuito = circuito;
        fecha = LocalDate.now();
        terminada = false;
        listaDeCorredores = new ArrayList<>();
    }

    public String getCarrera_id() {
        return carrera_id;
    }

    public void setCarrera_id(String carrera_id) {
        this.carrera_id = carrera_id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public List<Corredor> getListaDeCorredores() {
        return listaDeCorredores;
    }

    public boolean agregarCorredor(Piloto piloto, Auto auto){
        boolean agregado = false;
        Corredor corredor = new Corredor(carrera_id, piloto, auto, this);
        if(esCorredorValido(corredor)){
            agregado = listaDeCorredores.add(corredor);
        }
        return agregado;
    }

    private String obtenerCorredorId(){
        String codigo = carrera_id + "-";
        Corredor ultimoCorredor;
        if(listaDeCorredores.isEmpty()){
            codigo += "01";
        }else{
            ultimoCorredor = listaDeCorredores.get(listaDeCorredores.size()-1);
            int indice = ultimoCorredor.getCorredor_id().indexOf("-") + 1;
            int incremento = Integer.parseInt(ultimoCorredor.getCorredor_id().substring(indice)) + 1;
            if(incremento < 10){
                codigo += "0" + incremento;
            } else{
                codigo += incremento;
            }

        }
        return codigo;
    }

    private boolean esCorredorValido(Corredor nuevoCorredor){
        boolean corredorValido = true;
        Piloto nuevoPiloto = nuevoCorredor.getPiloto();
        Auto nuevoAuto = nuevoCorredor.getAuto();
        for(Corredor corredor : listaDeCorredores){
            Piloto piloto = corredor.getPiloto();
            Auto auto = corredor.getAuto();
            if (piloto.getPiloto_id().equals(nuevoPiloto.getPiloto_id()) ||
                auto.getAuto_id().equals(nuevoAuto.getAuto_id())) {
                corredorValido = false;
                break;
            }
        }
        return corredorValido;
    }

    public int obtenerTotalDeCorredores(){
        return listaDeCorredores.size();
    }

    private void correrVueltas(){
        for(int numeroDeVuelta = 1; numeroDeVuelta <= vueltas; numeroDeVuelta++){
            for( Corredor corredor : listaDeCorredores){
                corredor.correrVuelta(numeroDeVuelta);
            }
        }
        terminada = true;
    }

    private void ordenarListaDeCorredoresPorMejorTiempo(){
        Corredor corredorTemporal , corredorActual , corredorSiguiente;
        for(int i = 1 ; i< listaDeCorredores.size() ; i++){
            for (int j= 0 ; j< listaDeCorredores.size() - 1 ; j++){
                corredorActual = listaDeCorredores.get(j);
                corredorSiguiente = listaDeCorredores.get(j+1);
                if(corredorActual.calcularTiempoDeCarrera() > corredorSiguiente.calcularTiempoDeCarrera()){
                    corredorTemporal = corredorActual;
                    corredorActual = corredorSiguiente;
                    corredorSiguiente = corredorTemporal;
                    listaDeCorredores.set(j, corredorActual);
                    listaDeCorredores.set(j+1, corredorSiguiente);
                }
            }
        }
    }

    private void asignarPuestoPorCorredor(){
        Corredor corredor;
        for(int i = 0; i < listaDeCorredores.size() ; i++){
            corredor = listaDeCorredores.get(i);
            corredor.setPuesto( i + 1 );
        }
    }

    public Corredor obtenerCorredorGanador(){
        Corredor corredorGanador = null;
        if(!listaDeCorredores.isEmpty() && terminada){
            corredorGanador = listaDeCorredores.get(0);
        }
        return   corredorGanador;
    }

    public Corredor buscarCorredor(String corredor_id) {
        Corredor corredorBuscado = null;
        for (Corredor corredor : listaDeCorredores) {
            if (corredor.getCorredor_id().equals(corredor_id)) {
                corredorBuscado = corredor;
                break;
            }
        }
        return corredorBuscado;
    }

    private float calcularSumatoriaDeTiemposPorCorredor() {
        float sumatoriaDeTiemposPorCorredor = 0;
        for (Corredor corredor : listaDeCorredores) {
            sumatoriaDeTiemposPorCorredor += corredor.calcularTiempoDeCarrera();
        }
        return sumatoriaDeTiemposPorCorredor;
    }

    public float calcularTiempoPromedio() {
        return calcularSumatoriaDeTiemposPorCorredor() / listaDeCorredores.size();
    }

    private float calcularSumatoriaDeVarianza() {
        float sumatoriaDeVarianza = 0;
        float tiempoPromedio = calcularTiempoPromedio();
        for (Corredor corredor : listaDeCorredores) {
            sumatoriaDeVarianza += Math.pow(corredor.calcularTiempoDeCarrera() - tiempoPromedio, 2);
        }
        return sumatoriaDeVarianza;
    }

    public double calcularVarianzaDelTiempo() {
        return calcularSumatoriaDeVarianza() / listaDeCorredores.size();
    }

    public double calcularDesviacionEstandarDelTiempo() {
        return Math.sqrt(calcularVarianzaDelTiempo());
    }
}
