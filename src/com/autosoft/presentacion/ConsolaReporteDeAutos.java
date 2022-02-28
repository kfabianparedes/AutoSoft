package com.autosoft.presentacion;

import com.autosoft.tabla.Columna;
import com.autosoft.tabla.Tabla;
import com.autosoft.entidad.Auto;
import com.autosoft.repositorio.CatalogoDeAutos;
import java.util.ArrayList;
import java.util.List;

public class ConsolaReporteDeAutos extends ConsolaDeReporte {

    public ConsolaReporteDeAutos() {
        super("REPORTE DE AUTOS", "Fin del reporte de Autos");
    }

    @Override
    public void mostrarDetalle() {
        Tabla tabla = new Tabla(obtenerColumnas(), obtenerFilas());
        tabla.imprimirTabla();
    }    
    
    private Columna[] obtenerColumnas(){
        Columna[] columnas = new Columna[3];
        columnas[0] = new Columna("AutoId", 10);
        columnas[1] = new Columna("Motor", 15);
        columnas[2] = new Columna("VelMáxima", 10);
        return columnas;
    }
    
    private List<Object[]> obtenerFilas() {
        CatalogoDeAutos catalogoDeAutos = CatalogoDeAutos.obtenerInstancia();
        List<Auto> listaDeAutos = catalogoDeAutos.getListaDeAutos();
        List<Object[]> filas = new ArrayList();
        for (Auto auto : listaDeAutos) {
            filas.add(auto.obtenerDatos());
        }
        return filas;
    }

}
