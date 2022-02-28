/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autosoft.presentacion;

import com.autosoft.tabla.Columna;
import com.autosoft.tabla.Tabla;
import com.autosoft.entidad.Circuito;
import com.autosoft.repositorio.CatalogoDeCircuitos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows10
 */
public class ConsolaReporteDeCircuitos extends ConsolaDeReporte {

    public ConsolaReporteDeCircuitos() {
        super("REPORTE DE CIRCUITOS", "Fin del reporte de Circuitos");
    }

    @Override
    public void mostrarDetalle() {
        Tabla tabla = new Tabla(obtenerColumnas(), obtenerFilas());
        tabla.imprimirTabla();
    }

    private Columna[] obtenerColumnas() {
        Columna[] columnas = new Columna[4];
        columnas[0] = new Columna("CircuitoId", 12);
        columnas[1] = new Columna("Nombre", 20);
        columnas[2] = new Columna("Longitud", 10);
        columnas[3] = new Columna("Dificultad", 10);
        return columnas;
    }

    private List<Object[]> obtenerFilas() {
        CatalogoDeCircuitos catalogoDeCircuitos = CatalogoDeCircuitos.obtenerInstancia();
        List<Circuito> listaDeCircuitos = catalogoDeCircuitos.getListaDeCircuitos();
        List<Object[]> filas = new ArrayList();
        for (Circuito circuito : listaDeCircuitos) {
            filas.add(circuito.obtenerDatos());
        }
        return filas;
    }
}
