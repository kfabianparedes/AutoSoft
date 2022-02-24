package com.autosoft.repositorio;

import com.autosoft.entidad.Carrera;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDeCarreras {

    private static CatalogoDeCarreras catalogoDeCarreras;
    private List<Carrera> listaDeCarreras;

    private CatalogoDeCarreras() {
        listaDeCarreras = new ArrayList();       
    }

    public static CatalogoDeCarreras obtenerInstancia() {
        if (catalogoDeCarreras == null) {
            catalogoDeCarreras = new CatalogoDeCarreras();
        }
        return catalogoDeCarreras;
    }

    public List<Carrera> getListaDeCarreras() {
        return listaDeCarreras;
    }
    
    public List<Carrera> obtenerCarrerasTerminadas() {
        List<Carrera> carrerasTerminadas = new ArrayList();
        for(Carrera carrera : listaDeCarreras) {
            if(carrera.isTerminada()) {
                carrerasTerminadas.add(carrera);
            }
        }
        return carrerasTerminadas;
    }
    
    public List<Carrera> obtenerCarrerasSinIniciar() {
        List<Carrera> carrerasSinIniciar = new ArrayList();
        for(Carrera carrera : listaDeCarreras) {
            if(!carrera.isTerminada()) {
                carrerasSinIniciar.add(carrera);
            }
        }
        return carrerasSinIniciar;
    }

    public boolean agregarCarrera(Carrera carrera) {
        boolean carreraAgregada = false;
        if (buscarCarrera(carrera.getCarrera_id()) == null) {
            carreraAgregada = listaDeCarreras.add(carrera);
        }
        return carreraAgregada;
    }

    public Carrera buscarCarrera(String carrera_id) {
        Carrera carreraBuscada = null;
        for (Carrera carrera : listaDeCarreras) {
            if (carrera.getCarrera_id().equals(carrera_id)) {
                carreraBuscada = carrera;
                break;
            }
        }
        return carreraBuscada;
    }

}
