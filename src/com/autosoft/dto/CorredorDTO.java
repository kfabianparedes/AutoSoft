package com.autosoft.dto;

public class CorredorDTO {

    private String corredorId;
    private String pilotoId;
    private String pilotoNombre;
    private String pilotoTiempodeexperiencia;
    private String autoId;
    private String autoMotor;
    private String autoVelocidadmaxima;

    public String getCorredorId() {
        return corredorId;
    }

    public void setCorredorId(String corredorId) {
        this.corredorId = corredorId;
    }

    public String getPilotoId() {
        return pilotoId;
    }

    public void setPilotoId(String pilotoId) {
        this.pilotoId = pilotoId;
    }

    public String getPilotoNombre() {
        return pilotoNombre;
    }

    public void setPilotoNombre(String pilotoNombre) {
        this.pilotoNombre = pilotoNombre;
    }

    public String getPilotoTiempodeexperiencia() {
        return pilotoTiempodeexperiencia;
    }

    public void setPilotoTiempodeexperiencia(String pilotoTiempodeexperiencia) {
        this.pilotoTiempodeexperiencia = pilotoTiempodeexperiencia;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String getAutoMotor() {
        return autoMotor;
    }

    public void setAutoMotor(String autoMotor) {
        this.autoMotor = autoMotor;
    }

    public String getAutoVelocidadmaxima() {
        return autoVelocidadmaxima;
    }

    public void setAutoVelocidadmaxima(String autoVelocidadmaxima) {
        this.autoVelocidadmaxima = autoVelocidadmaxima;
    }
    
    public Object[] getDatosCompletos() {
        Object[] arreglo = new Object[7];
        arreglo[0] = corredorId;
        arreglo[1] = pilotoId;
        arreglo[2] = pilotoNombre;
        arreglo[3] = pilotoTiempodeexperiencia;
        arreglo[4] = autoId;
        arreglo[5] = autoMotor;
        arreglo[6] = autoVelocidadmaxima;
        return arreglo;
    } 
    
}
