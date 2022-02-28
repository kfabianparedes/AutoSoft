package com.autosoft.entidad;

public class Piloto {
    private String piloto_id;
    private String nombre;
    private int tiempodeexperiencia;

    public Piloto(String piloto_id, String nombre, int tiempodeexperiencia) {
        this.piloto_id = piloto_id;
        this.nombre = nombre;
        this.tiempodeexperiencia = tiempodeexperiencia;
    }

    public String getPiloto_id() {
        return piloto_id;
    }

    public void setPiloto_id(String piloto_id) {
        this.piloto_id = piloto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempodeexperiencia() {
        return tiempodeexperiencia;
    }

    public void setTiempodeexperiencia(int tiempodeexperiencia) {
        this.tiempodeexperiencia = tiempodeexperiencia;
    }

    // Método de clase - Reglas de negocio

    public float calcularProbabildadDeExito(){
        float probabildadDeExito;
        if(tiempodeexperiencia <= 2 ){
            probabildadDeExito = 0.2f;
        }else if (tiempodeexperiencia <= 6){
            probabildadDeExito = 0.5f;
        }else if (tiempodeexperiencia <= 10){
            probabildadDeExito = 0.8f;
        }else{
            probabildadDeExito = 1.0f;
        }
        return probabildadDeExito;
    }
    
    public Object[] obtenerDatos(){
        Object[] arreglo = new Object[3];
        arreglo[0] = piloto_id;
        arreglo[1] = nombre;
        arreglo[2] = tiempodeexperiencia;
        return arreglo;
    }
}
