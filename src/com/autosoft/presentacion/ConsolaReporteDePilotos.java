/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autosoft.presentacion;

import com.autosoft.tabla.Columna;
import com.autosoft.tabla.Tabla;
import com.autosoft.entidad.Piloto;
import com.autosoft.repositorio.CatalogoDePilotos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows10
 */
public class ConsolaReporteDePilotos extends ConsolaDeReporte {

    public ConsolaReporteDePilotos() {
        super("REPORTE DE PILOTOS", "Fin del reporte de Pilotos");
    }

    @Override
    public void mostrarDetalle() {     
        Tabla tabla = new Tabla(obtenerColumnas(), obtenerFilas());
        tabla.imprimirTabla();
    }
    
    private Columna[] obtenerColumnas(){
        Columna[] columnas = new Columna[3];
        columnas[0] = new Columna("PilotoId", 10);
        columnas[1] = new Columna("Nombre", 20);
        columnas[2] = new Columna("Experiencia", 11);
        return columnas;
    }
    
    private List<Object[]> obtenerFilas() {
        CatalogoDePilotos catalogoDePilotos = CatalogoDePilotos.obtenerInstancia();
        List<Piloto> listaDePilotos = catalogoDePilotos.getListaDePilotos();
        List<Object[]> filas = new ArrayList();
        for (Piloto piloto : listaDePilotos) {
            filas.add(piloto.obtenerDatos());
        }
        return filas;
    }

}
