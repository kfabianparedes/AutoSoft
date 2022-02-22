package com.autosoft.entidad;

public class Auto {
    private String auto_id;
    private String modelo;
    private int maximavelocidad;

    public Auto(String auto_id, String modelo, int maximavelocidad) {
        this.auto_id = auto_id;
        this.modelo = modelo;
        this.maximavelocidad = maximavelocidad;
    }

    public String getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(String auto_id) {
        this.auto_id = auto_id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMaximavelocidad() {
        return maximavelocidad;
    }

    public void setMaximavelocidad(int maximavelocidad) {
        this.maximavelocidad = maximavelocidad;
    }
    
    public float calcularVelocidad(){
        return (maximavelocidad - (float)((maximavelocidad / 2 ) * Math.random()));
    }
}
