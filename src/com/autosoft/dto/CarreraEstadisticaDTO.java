package com.autosoft.dto;

public class CarreraEstadisticaDTO {

    private String carreraId;
    private int vueltas;
    private int totalDeCorredores;
    private String longitudEnMetros;
    private String pilotoGanador;
    private String tiempoPiloto;
    private String tiempoPromedio;
    private String varianzaDelTiempo;
    private String desviacionEstandarDelTiempo;

    public String getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(String carreraId) {
        this.carreraId = carreraId;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public int getTotalDeCorredores() {
        return totalDeCorredores;
    }

    public void setTotalDeCorredores(int totalDeCorredores) {
        this.totalDeCorredores = totalDeCorredores;
    }

    public String getLongitudEnMetros() {
        return longitudEnMetros;
    }

    public void setLongitudEnMetros(String longitudEnMetros) {
        this.longitudEnMetros = longitudEnMetros;
    }

    public String getPilotoGanador() {
        return pilotoGanador;
    }

    public void setPilotoGanador(String pilotoGanador) {
        this.pilotoGanador = pilotoGanador;
    }

    public String getTiempoPiloto() {
        return tiempoPiloto;
    }

    public void setTiempoPiloto(String tiempoPiloto) {
        this.tiempoPiloto = tiempoPiloto;
    }

    public String getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(String tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public String getVarianzaDelTiempo() {
        return varianzaDelTiempo;
    }

    public void setVarianzaDelTiempo(String varianzaDelTiempo) {
        this.varianzaDelTiempo = varianzaDelTiempo;
    }

    public String getDesviacionEstandarDelTiempo() {
        return desviacionEstandarDelTiempo;
    }

    public void setDesviacionEstandarDelTiempo(String desviacionEstandarDelTiempo) {
        this.desviacionEstandarDelTiempo = desviacionEstandarDelTiempo;
    }
    
    public Object[] getDatosCompletos() {
        Object[] arreglo = new Object[9];
        arreglo[0] = carreraId;
        arreglo[1] = vueltas;
        arreglo[2] = totalDeCorredores;
        arreglo[3] = longitudEnMetros;
        arreglo[4] = pilotoGanador;
        arreglo[5] = tiempoPiloto;
        arreglo[6] = tiempoPromedio;
        arreglo[7] = varianzaDelTiempo;
        arreglo[8] = desviacionEstandarDelTiempo;
        return arreglo;
    } 

}
