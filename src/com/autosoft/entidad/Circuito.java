package com.autosoft.entidad;

public class Circuito {
    private String circuito_id;
    private String nombre;
    private int longitudEnMetros;
    private String dificultad;
    public static final String DIFICULTAD_BAJA = "Baja";
    public static final String DIFICULTAD_MEDIA = "Media";
    public static final String DIFICULTAD_ALTA = "Alta";

    public Circuito(String circuito_id, String nombre, int longitudEnMetros, String dificultad) {
        this.circuito_id = circuito_id;
        this.nombre = nombre;
        this.longitudEnMetros = longitudEnMetros;
        this.dificultad = dificultad;
    }

    public String getCircuito_id() {
        return circuito_id;
    }

    public void setCircuito_id(String circuito_id) {
        this.circuito_id = circuito_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLongitudEnMetros() {
        return longitudEnMetros;
    }

    public void setLongitudEnMetros(int longitudEnMetros) {
        this.longitudEnMetros = longitudEnMetros;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public float calcularLongitudEnKilometros(){
        return longitudEnMetros / 1000f;
    }
}
