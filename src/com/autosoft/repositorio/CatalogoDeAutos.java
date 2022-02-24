package com.autosoft.repositorio;

import com.autosoft.entidad.Auto;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDeAutos {

    private static CatalogoDeAutos catalogoDeAutos;
    private List<Auto> listaDeAutos;

    private CatalogoDeAutos() {
        crearAutos();
    }

    public static CatalogoDeAutos obtenerInstancia() {
        if (catalogoDeAutos == null) {
            catalogoDeAutos = new CatalogoDeAutos();
        }
        return catalogoDeAutos;
    }

    private void crearAutos() {
        listaDeAutos = new ArrayList();
        listaDeAutos.add(new Auto("A001", "Mercedes", 200));
        listaDeAutos.add(new Auto("A002", "Ferrari", 300));
        listaDeAutos.add(new Auto("A003", "Renault", 230));
        listaDeAutos.add(new Auto("A004", "Red Bull", 240));
        listaDeAutos.add(new Auto("A005", "Ford", 250));
        listaDeAutos.add(new Auto("A006", "Honda", 280));
        listaDeAutos.add(new Auto("A007", "BMW", 230));
        listaDeAutos.add(new Auto("A008", "Renault", 240));
        listaDeAutos.add(new Auto("A009", "Mercedes", 250));
        listaDeAutos.add(new Auto("A010", "Ferrari", 280));
    }

    public List<Auto> getListaDeAutos() {
        return listaDeAutos;
    }

    public Auto buscarAuto(String auto_id) {
        Auto autoBuscado = null;
        for (Auto auto : listaDeAutos) {
            if (auto.getAuto_id().equals(auto_id)) {
                autoBuscado = auto;
                break;
            }
        }
        return autoBuscado;
    }
}//end CatalogoDeAutos
