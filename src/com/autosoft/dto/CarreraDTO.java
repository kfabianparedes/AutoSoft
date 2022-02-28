package com.autosoft.dto;

import java.time.LocalDate;

public class CarreraDTO {

    private String carreraId;
    private LocalDate fecha;
    private int vueltas;
    private String premio;
    private String terminada;
    private int totalCorredores;
    private String circuitoId;
    private String circuitoNombre;
    private String longitudEnMetros;
    private String dificultad;

    public String getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(String carreraId) {
        this.carreraId = carreraId;
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

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public String getTerminada() {
        return terminada;
    }

    public void setTerminada(String terminada) {
        this.terminada = terminada;
    }

    public int getTotalCorredores() {
        return totalCorredores;
    }

    public void setTotalCorredores(int totalCorredores) {
        this.totalCorredores = totalCorredores;
    }

    public String getCircuitoId() {
        return circuitoId;
    }

    public void setCircuitoId(String circuitoId) {
        this.circuitoId = circuitoId;
    }

    public String getCircuitoNombre() {
        return circuitoNombre;
    }

    public void setCircuitoNombre(String circuitoNombre) {
        this.circuitoNombre = circuitoNombre;
    }

    public String getLongitudEnMetros() {
        return longitudEnMetros;
    }

    public void setLongitudEnMetros(String longitudEnMetros) {
        this.longitudEnMetros = longitudEnMetros;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Object[] getDatosCompletos() {
        Object[] carreraDTOArreglo = new Object[10];
        carreraDTOArreglo[0] = carreraId;
        carreraDTOArreglo[1] = fecha;
        carreraDTOArreglo[2] = vueltas;
        carreraDTOArreglo[3] = premio;
        carreraDTOArreglo[4] = terminada;
        carreraDTOArreglo[5] = totalCorredores;
        carreraDTOArreglo[6] = circuitoId;
        carreraDTOArreglo[7] = circuitoNombre;
        carreraDTOArreglo[8] = longitudEnMetros;
        carreraDTOArreglo[9] = dificultad;
        return carreraDTOArreglo;
    } 

}
