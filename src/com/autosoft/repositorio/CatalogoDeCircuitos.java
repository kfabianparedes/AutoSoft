package com.autosoft.repositorio;

import com.autosoft.entidad.Circuito;

import java.util.ArrayList;
import java.util.List;

public class CatalogoDeCircuitos {

    private List<Circuito> listaDeCircuitos;
    private static CatalogoDeCircuitos catalogoDeCircuitos;

    private CatalogoDeCircuitos() {
        crearCircuitos();
    }

    private void crearCircuitos() {
        listaDeCircuitos = new ArrayList();
        listaDeCircuitos.add(new Circuito("C001", "La Ballena", 5000, Circuito.DIFICULTAD_ALTA));
        listaDeCircuitos.add(new Circuito("C002", "El Perro", 2000, Circuito.DIFICULTAD_BAJA));
        listaDeCircuitos.add(new Circuito("C003", "El Mono", 3500, Circuito.DIFICULTAD_MEDIA));
        listaDeCircuitos.add(new Circuito("C004", "El Cóndor", 3500, Circuito.DIFICULTAD_ALTA));
        listaDeCircuitos.add(new Circuito("C005", "El Colibri", 1800, Circuito.DIFICULTAD_BAJA));
        listaDeCircuitos.add(new Circuito("C006", "La Araña", 2700, Circuito.DIFICULTAD_MEDIA));
    }

    public static CatalogoDeCircuitos obtenerInstancia() {
        if (catalogoDeCircuitos == null) {
            catalogoDeCircuitos = new CatalogoDeCircuitos();
        }
        return catalogoDeCircuitos;
    }

    public List<Circuito> getListaDeCircuitos() {
        return listaDeCircuitos;
    }

    public Circuito buscarCircuito(String circuito_id) {
        Circuito circuitoBuscado = null;
        for (Circuito circuito : listaDeCircuitos) {
            if (circuito.getCircuito_id().equals(circuito_id)) {
                circuitoBuscado = circuito;
                break;
            }
        }
        return circuitoBuscado;
    }
}//end CatalogoDeCircuitos
