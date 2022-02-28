package com.autosoft.dto;

public class CorredorEstadisticaDTO {

    private int puesto;
    private String corredorId;
    private String pilotoNombre;
    private String motor;
    private String tiempoDeCarrera;
    private String tiempoPromedioDeVuelta;
    private String varianzaDelTiempo;
    private String DesviacionEstandarDelTiempo;
    private String velocidadPromedioDeVuelta;
    private int vueltaMasRapida;
    private String velocidadVueltaRapida;
    private String tiempoVueltaRapida;
    private int vueltaMasLenta;
    private String velocidadVueltaLenta;
    private String tiempoVueltaLenta;

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String getCorredorId() {
        return corredorId;
    }

    public void setCorredorId(String corredorId) {
        this.corredorId = corredorId;
    }

    public String getPilotoNombre() {
        return pilotoNombre;
    }

    public void setPilotoNombre(String pilotoNombre) {
        this.pilotoNombre = pilotoNombre;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String  getTiempoDeCarrera() {
        return tiempoDeCarrera;
    }

    public void setTiempoDeCarrera(String  tiempoDeCarrera) {
        this.tiempoDeCarrera = tiempoDeCarrera;
    }

    public String  getTiempoPromedioDeVuelta() {
        return tiempoPromedioDeVuelta;
    }

    public void setTiempoPromedioDeVuelta(String  tiempoPromedioDeVuelta) {
        this.tiempoPromedioDeVuelta = tiempoPromedioDeVuelta;
    }

    public String getVarianzaDelTiempo() {
        return varianzaDelTiempo;
    }

    public void setVarianzaDelTiempo(String varianzaDelTiempo) {
        this.varianzaDelTiempo = varianzaDelTiempo;
    }

    public String getDesviacionEstandarDelTiempo() {
        return DesviacionEstandarDelTiempo;
    }

    public void setDesviacionEstandarDelTiempo(String DesviacionEstandarDelTiempo) {
        this.DesviacionEstandarDelTiempo = DesviacionEstandarDelTiempo;
    }

    public String  getVelocidadPromedioDeVuelta() {
        return velocidadPromedioDeVuelta;
    }

    public void setVelocidadPromedioDeVuelta(String  velocidadPromedioDeVuelta) {
        this.velocidadPromedioDeVuelta = velocidadPromedioDeVuelta;
    }

    public int getVueltaMasRapida() {
        return vueltaMasRapida;
    }

    public void setVueltaMasRapida(int vueltaMasRapida) {
        this.vueltaMasRapida = vueltaMasRapida;
    }

    public String  getVelocidadVueltaRapida() {
        return velocidadVueltaRapida;
    }

    public void setVelocidadVueltaRapida(String  velocidadVueltaRapida) {
        this.velocidadVueltaRapida = velocidadVueltaRapida;
    }

    public String  getTiempoVueltaRapida() {
        return tiempoVueltaRapida;
    }

    public void setTiempoVueltaRapida(String  tiempoVueltaRapida) {
        this.tiempoVueltaRapida = tiempoVueltaRapida;
    }

    public int getVueltaMasLenta() {
        return vueltaMasLenta;
    }

    public void setVueltaMasLenta(int vueltaMasLenta) {
        this.vueltaMasLenta = vueltaMasLenta;
    }

    public String  getVelocidadVueltaLenta() {
        return velocidadVueltaLenta;
    }

    public void setVelocidadVueltaLenta(String  velocidadVueltaLenta) {
        this.velocidadVueltaLenta = velocidadVueltaLenta;
    }

    public String  getTiempoVueltaLenta() {
        return tiempoVueltaLenta;
    }

    public void setTiempoVueltaLenta(String  tiempoVueltaLenta) {
        this.tiempoVueltaLenta = tiempoVueltaLenta;
    }
    
    public Object[] getDatosCompletos() {
        Object[] arreglo = new Object[14];
        arreglo[0] = puesto;
        arreglo[1] = corredorId;
        arreglo[2] = pilotoNombre;
        arreglo[3] = tiempoDeCarrera;
        arreglo[4] = tiempoPromedioDeVuelta;
        arreglo[5] = varianzaDelTiempo;
        arreglo[6] = DesviacionEstandarDelTiempo;
        arreglo[7] = velocidadPromedioDeVuelta;
        arreglo[8] = vueltaMasRapida;
        arreglo[9] = velocidadVueltaRapida;
        arreglo[10] = tiempoVueltaRapida;
        arreglo[11] = vueltaMasLenta;
        arreglo[12] = velocidadVueltaLenta;
        arreglo[13] = tiempoVueltaLenta;
        return arreglo;
    }

    
    public Object[] getDatosParciales() {
        Object[] arreglo = new Object[5];
        arreglo[0] = puesto;
        arreglo[1] = corredorId;
        arreglo[2] = pilotoNombre;
        arreglo[3] = motor;
        arreglo[4] = tiempoDeCarrera;
        return arreglo;
    }

}
