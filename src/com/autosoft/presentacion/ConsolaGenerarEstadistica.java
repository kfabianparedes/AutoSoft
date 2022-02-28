package com.autosoft.presentacion;

import com.autosoft.dto.CarreraEstadisticaDTO;
import com.autosoft.dto.CorredorEstadisticaDTO;
import com.autosoft.util.Consola;
import com.autosoft.entidad.Carrera;
import com.autosoft.entidad.Corredor;
import com.autosoft.mapeador.Mapeador;
import com.autosoft.repositorio.CatalogoDeCarreras;
import com.autosoft.tabla.Columna;
import com.autosoft.tabla.Tabla;
import java.util.ArrayList;
import java.util.List;

public class ConsolaGenerarEstadistica extends ConsolaDeEntrada {

//    private Carrera carrera;
    public ConsolaGenerarEstadistica() {
        super("REPORTE DE ESTADISTICAS");
    }

    @Override
    public void mostrar() {
        String opcion;
        do {
            mostrarEncabezado();
            mostrarEstadisticaDeCarreras();
            do {
                Consola.imprimirMensajeConSatoDeLinea(">> (C) Consultar Carrera | (S) Salir:");
                opcion = entradaDeConsola.next().toUpperCase();
            } while (!opcion.equals("C") && !opcion.equals("S"));
            if (opcion.equals("C")) {
                buscarCarrera();
            }
        } while (!opcion.equals("S"));
    }

    private void mostrarEstadisticaDeCarreras() {
        Consola.imprimirMensaje("Estadística de Carreras");
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        List<Carrera> listaDeCarrerasTerminadas = catalogoDeCarreras.obtenerCarrerasTerminadas();
        List<Object[]> filas = new ArrayList();
        Mapeador mapeadorDTO = new Mapeador();
        for (Carrera carrera : listaDeCarrerasTerminadas) {
            CarreraEstadisticaDTO carreraEstadisticaDTO = mapeadorDTO.crearCarreraEstadisticaDTO(carrera);
            filas.add(carreraEstadisticaDTO.getDatosCompletos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeCarreraEstadistica(), filas);
        tabla.imprimirTabla();
    }

    private void buscarCarrera() {
        String letra;
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        Consola.imprimirMensajeConSatoDeLinea(">> Ingrese un código de Carrera:");
        String codigoDeCarrera = entradaDeConsola.next().toUpperCase();
        Carrera carrera = catalogoDeCarreras.buscarCarrera(codigoDeCarrera);
        if (carrera == null || !carrera.isTerminada()) {
            if (carrera == null) {
                Consola.imprimirMensaje("Advertencia: el código no existe.");
            } else if (!carrera.isTerminada()) {
                Consola.imprimirMensaje("Advertencia: el código pertenece a una Carrera no ejecutada.");
            }
            do {
                Consola.imprimirMensajeConSatoDeLinea(">> Ingrese 'S' para seguir:");
                letra = entradaDeConsola.next().toUpperCase();
            } while (!letra.equals("S"));
        } else {
            mostrarEstadisticaDeCorredores(carrera);
        }
    }

    private void mostrarEstadisticaDeCorredores(Carrera carrera) {
        String letra;        
        Mapeador mapeadorDTO = new Mapeador();
        mostrarEncabezado();
        //****
        CarreraEstadisticaDTO carreraEstadisticaDTO = mapeadorDTO.crearCarreraEstadisticaDTO(carrera);
        Consola.imprimirSubTitulo("Estadística de Carrera");
        Consola.imprimirMensaje("CarreraId                     : " + carreraEstadisticaDTO.getCarreraId());
        Consola.imprimirMensaje("Vueltas                       : " + carreraEstadisticaDTO.getVueltas());
        Consola.imprimirMensaje("Corredores                    : " + carreraEstadisticaDTO.getTotalDeCorredores());        
        Consola.imprimirMensaje("Longitud                      : " + carreraEstadisticaDTO.getLongitudEnMetros());
        Consola.imprimirMensaje("Piloto ganador                : " + carreraEstadisticaDTO.getPilotoGanador());
        Consola.imprimirMensaje("Tiempo del Piloto             : " + carreraEstadisticaDTO.getTiempoPiloto());
        Consola.imprimirMensaje("Tiempo promedio               : " + carreraEstadisticaDTO.getTiempoPromedio());
        Consola.imprimirMensaje("Varianza del tiempo           : " + carreraEstadisticaDTO.getVarianzaDelTiempo());        
        Consola.imprimirMensaje("Desviación Estandar del tiempo: " + carreraEstadisticaDTO.getDesviacionEstandarDelTiempo());
        //****
        CorredorEstadisticaDTO corredorEstadisticaDTO;
        List<Object[]> filas = new ArrayList();        
        Consola.imprimirMensajeConSatoDeLinea("Estadística de Corredores");        
        for (Corredor corredor : carrera.getListaDeCorredores()) {
            corredorEstadisticaDTO = mapeadorDTO.crearCorredorEstadisticaDTO(corredor);
            filas.add(corredorEstadisticaDTO.getDatosCompletos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeCorredorEstadistica(), filas);
        tabla.imprimirTabla();
        //****
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese 'S' para salir:");
            letra = entradaDeConsola.next().toUpperCase();
        } while (!letra.equals("S"));
    }

    private Columna[] obtenerColumnasDeCarreraEstadistica() {
        Columna[] columnas = new Columna[9];
        columnas[0] = new Columna("CarreraId", 11);
        columnas[1] = new Columna("Vueltas", 9);
        columnas[2] = new Columna("Corredores", 12);
        columnas[3] = new Columna("Longitud", 10);
        columnas[4] = new Columna("PilotoGanador", 25);
        columnas[5] = new Columna("TiemPiloto", 12);
        columnas[6] = new Columna("TiemPromedio", 14);
        columnas[7] = new Columna("VarTiempo", 11);
        columnas[8] = new Columna("DesEstTiempo", 12);
        return columnas;
    }

    private Columna[] obtenerColumnasDeCorredorEstadistica() {
        Columna[] columnas = new Columna[14];
        columnas[0] = new Columna("Puesto", 7);
        columnas[1] = new Columna("CorredorId", 12);
        columnas[2] = new Columna("Piloto", 20);
        columnas[3] = new Columna("TiemTotal", 14);
        columnas[4] = new Columna("TiemPromVuelta", 15);
        columnas[5] = new Columna("VarTiempo", 11);
        columnas[6] = new Columna("DesEstTiempo", 13);
        columnas[7] = new Columna("VelPromVuelta", 14);
        columnas[8] = new Columna("VueltaRápida", 13);
        columnas[9] = new Columna("VelVueltaRápida", 16);
        columnas[10] = new Columna("TiemVueltaRapida", 17);
        columnas[11] = new Columna("VueltaLenta", 12);
        columnas[12] = new Columna("VelVueltaLenta", 15);
        columnas[13] = new Columna("TiemVueltaLenta", 15);
        return columnas;
    }

}
