package com.autosoft.repositorio;

import com.autosoft.entidad.Piloto;

import java.util.ArrayList;
import java.util.List;

public class CatalogoDePilotos {
    private List<Piloto> listaDePilotos;
    private static CatalogoDePilotos catalogoDePilotos;
    
    private CatalogoDePilotos(){
        
    }
    
    public static CatalogoDePilotos obtenerInstancia(){
        if(catalogoDePilotos == null){
            catalogoDePilotos = new CatalogoDePilotos();
        }
        return catalogoDePilotos;
    }

    private void crearPilotos(){
        listaDePilotos = new ArrayList();
        listaDePilotos.add(new Piloto("P001","Edwin Mendoza",5));
        listaDePilotos.add(new Piloto("P002","Marcelino Torres",15));
        listaDePilotos.add(new Piloto("P003","Fernando Luque",8));
        listaDePilotos.add(new Piloto("P004","Yosip Urquiso",5));
    }

    public List<Piloto> getListaDePilotos(){
        return listaDePilotos;
    }

    public  Piloto buscarPiloto(String piloto_id){
        Piloto pilotoBuscado = null;
        for(Piloto piloto : listaDePilotos){
            if(piloto.getPiloto_id().equals(piloto_id)) {
                pilotoBuscado = piloto;
                break;
            }
        }
        return pilotoBuscado;
    }
}

