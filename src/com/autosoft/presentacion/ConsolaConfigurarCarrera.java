package com.autosoft.presentacion;

import com.autosoft.tabla.Columna;
import com.autosoft.tabla.Tabla;
import com.autosoft.util.Consola;
import com.autosoft.dto.CarreraDTO;
import com.autosoft.dto.CorredorDTO;
import com.autosoft.entidad.Auto;
import com.autosoft.entidad.Carrera;
import com.autosoft.entidad.Circuito;
import com.autosoft.entidad.Corredor;
import com.autosoft.entidad.Piloto;
import com.autosoft.mapeador.Mapeador;
import com.autosoft.repositorio.CatalogoDeCarreras;
import com.autosoft.repositorio.CatalogoDeCircuitos;
import com.autosoft.repositorio.CatalogoDePilotos;
import com.autosoft.repositorio.CatalogoDeAutos;
import java.util.ArrayList;
import java.util.List;


public class ConsolaConfigurarCarrera extends ConsolaDeEntrada {

    public ConsolaConfigurarCarrera() {
        super("CONFIGURAR CARRERAS");
    }

    @Override
    public void mostrar() {
        String opcion;
        do {
            mostrarEncabezado();
            mostrarCarreras();
            do {
                Consola.imprimirMensajeConSatoDeLinea(">> (I) Ingresar | (B) Buscar | (S) Salir:");
                opcion = entradaDeConsola.next().toUpperCase();
            } while (!opcion.equals("I") && !opcion.equals("B") && !opcion.equals("S"));
            if (opcion.equals("I")) {
                ingresarCarrera();
            } else if (opcion.equals("B")) {
                buscarCarrera();
            }
        } while (!opcion.equals("S"));
    }

    private void mostrarCarreras() {
        Consola.imprimirMensaje("Lista de Carreras");
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        List<Carrera> listaDeCarreras = catalogoDeCarreras.getListaDeCarreras();
        List<Object[]> filas = new ArrayList();
        Mapeador mapeadorDTO = new Mapeador();
        for (Carrera carrera : listaDeCarreras) {
            CarreraDTO carreraDTO = mapeadorDTO.crearCarreraDTO(carrera);
            filas.add(carreraDTO.getDatosCompletos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeCarrera(), filas);
        tabla.imprimirTabla();
    }

    private void ingresarCarrera() {
        String letra;
        Consola.imprimirMensaje(">> Ingrese un nuevo código de Carrera:");
        String codigoDeCarrera = entradaDeConsola.next().toUpperCase();
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        Carrera carrera = catalogoDeCarreras.buscarCarrera(codigoDeCarrera);
        if (carrera == null) {
            crearCarrera(codigoDeCarrera);
        } else {
            Consola.imprimirMensaje("Advertencia: el código de Carrera ya existe.");
        }
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese 'S' para seguir:");
            letra = entradaDeConsola.next().toUpperCase();
        } while (!letra.equals("S"));
    }

    private void buscarCarrera() {
        String letra;
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        Consola.imprimirMensaje(">> Ingrese un código de Carrera existente:");
        String codigoDeCarrera = entradaDeConsola.next().toUpperCase();
        Carrera carrera = catalogoDeCarreras.buscarCarrera(codigoDeCarrera);
        if (carrera == null) {
            Consola.imprimirMensaje("Advertencia: el código de Carrera no existe.");
        } else {
            mostrarCarrera(carrera);
        }
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese 'S' para seguir:");
            letra = entradaDeConsola.next().toUpperCase();
        } while (!letra.equals("S"));
    }

    private void crearCarrera(String codigoDeCarrera) {
        String vueltas, premio;
        Circuito circuito;
        Carrera carrera;
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        mostrarEncabezado();
        Consola.imprimirSubTitulo("Ingresar Carrera (" + codigoDeCarrera + ")");
        do {
            Consola.imprimirMensaje(">> Ingrese el número de vueltas:");
            vueltas = entradaDeConsola.next();
        } while (!Consola.esEntero(vueltas));
        do {
            Consola.imprimirMensaje(">> Ingrese el monto del premio :");
            premio = entradaDeConsola.next();
        } while (!Consola.esDecimal(premio));
        circuito = buscarCircuito();
        carrera = new Carrera(codigoDeCarrera, Integer.parseInt(vueltas), Double.parseDouble(premio), circuito);
        registrarCorredores(carrera);
        if (carrera.obtenerTotalDeCorredores() >= 2) {
            catalogoDeCarreras.agregarCarrera(carrera);
            Consola.imprimirMensaje("Se agregó la Carrera a la lista de carreras.");
        } else {
            Consola.imprimirMensaje("Advertencia: No se pudo guardar la Carrera.");
            Consola.imprimirMensaje("Deben existir al menos dos Corredores en la Carrera.");
        }
    }

    private Circuito buscarCircuito() {
        String letra;
        Circuito circuitoSeleccionado = null;
        String codigoDeCircuito;
        mostrarEncabezado();
        Consola.imprimirMensaje("Lista de Circuitos");
        //****
        CatalogoDeCircuitos catalogoDeCircuitos = CatalogoDeCircuitos.obtenerInstancia();
        List<Circuito> listaDeCircuitos = catalogoDeCircuitos.getListaDeCircuitos();
        List<Object[]> filas = new ArrayList();
        for (Circuito circuito : listaDeCircuitos) {
            filas.add(circuito.obtenerDatos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeCircuito(), filas);
        tabla.imprimirTabla();
        //****
        do {
            Consola.imprimirMensaje(">> Ingrese el código del Circuito:");
            codigoDeCircuito = entradaDeConsola.next().toUpperCase();
            circuitoSeleccionado = catalogoDeCircuitos.buscarCircuito(codigoDeCircuito);
            if (circuitoSeleccionado == null) {
                Consola.imprimirMensaje("Advertencia: El código del Circuito no existe.");
            }
        } while (circuitoSeleccionado == null);
        Consola.imprimirSubTitulo("Datos del Circuito seleccionado");
        Consola.imprimirMensaje("Código     :" + circuitoSeleccionado.getCircuito_id());
        Consola.imprimirMensaje("Nombre     :" + circuitoSeleccionado.getNombre());
        Consola.imprimirMensaje("Longitud   :" + circuitoSeleccionado.getLongitudEnMetros());
        Consola.imprimirMensaje("Dificultad :" + circuitoSeleccionado.getDificultad());
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese 'S' para seguir:");
            letra = entradaDeConsola.next().toUpperCase();
        } while (!letra.equals("S"));
        return circuitoSeleccionado;
    }

    private void registrarCorredores(Carrera carrera) {
        Piloto piloto;
        Auto auto;
        String opcion;
        do {
            mostrarEncabezado();
            Consola.imprimirSubTitulo("Ingresar Corredores");
            piloto = buscarPiloto();
            auto = buscarAuto();
            if (carrera.agregarCorredor(piloto, auto)) {
                Consola.imprimirMensaje("Se agregó el Corredor a la Carrera.");
            } else {
                Consola.imprimirMensaje("Advertencia: No se pudo agregar el Corredor a la Carrera, se repite algún dato.");
            }
            do {
                Consola.imprimirMensajeConSatoDeLinea(">> (I) Ingresar | (S) Salir:");
                opcion = entradaDeConsola.next().toUpperCase();
            } while (!opcion.equals("I") && !opcion.equals("S"));
        } while (opcion.equals("I"));
    }

    private Piloto buscarPiloto() {
        Piloto pilotoSeleccionado;
        String codigoDePiloto;
        Consola.imprimirMensajeConSatoDeLinea("Lista de Pilotos");
        //****
        CatalogoDePilotos catalogoDePilotos = CatalogoDePilotos.obtenerInstancia();
        List<Piloto> listaDePilotos = catalogoDePilotos.getListaDePilotos();
        List<Object[]> filas = new ArrayList();
        for (Piloto piloto : listaDePilotos) {
            filas.add(piloto.obtenerDatos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDePiloto(), filas);
        tabla.imprimirTabla();
        //****
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese el código del Piloto:");
            codigoDePiloto = entradaDeConsola.next().toUpperCase();
            pilotoSeleccionado = catalogoDePilotos.buscarPiloto(codigoDePiloto);
            if (pilotoSeleccionado == null) {
                Consola.imprimirMensaje("Advertencia: El código del Piloto no existe.");
            }
        } while (pilotoSeleccionado == null);
        return pilotoSeleccionado;
    }

    private Auto buscarAuto() {
        Auto autoSeleccionado;
        String codigoDeAuto;
        Consola.imprimirMensajeConSatoDeLinea("Lista de Autos");
        //****
        CatalogoDeAutos catalogoDeAutos = CatalogoDeAutos.obtenerInstancia();
        List<Auto> listaDeAutos = catalogoDeAutos.getListaDeAutos();
        List<Object[]> filas = new ArrayList();
        for (Auto auto : listaDeAutos) {
            filas.add(auto.obtenerDatos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeAuto(), filas);
        tabla.imprimirTabla();
        //****
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese el código del Auto:");
            codigoDeAuto = entradaDeConsola.next().toUpperCase();
            autoSeleccionado = catalogoDeAutos.buscarAuto(codigoDeAuto);
            if (autoSeleccionado == null) {
                Consola.imprimirMensaje("Advertencia: El código del Auto no existe.");
            }
        } while (autoSeleccionado == null);
        return autoSeleccionado;
    }

    private void mostrarCarrera(Carrera carrera) {
        Mapeador mapeadorDTO = new Mapeador();
        CorredorDTO corredorDTO;
        CarreraDTO carreraDTO = mapeadorDTO.crearCarreraDTO(carrera);
        mostrarEncabezado();
        Consola.imprimirSubTitulo("Datos de la Carrera");
        Consola.imprimirMensaje("Código     :" + carreraDTO.getCarreraId());
        Consola.imprimirMensaje("Corredores :" + carreraDTO.getTotalCorredores());
        Consola.imprimirMensaje("Estado     :" + carreraDTO.getTerminada());
        Consola.imprimirMensaje("");
        Consola.imprimirSubTitulo("Datos del Circuito");
        Consola.imprimirMensaje("Código     :" + carreraDTO.getCircuitoId());
        Consola.imprimirMensaje("Nombre     :" + carreraDTO.getCircuitoNombre());
        Consola.imprimirMensaje("Longitud   :" + carreraDTO.getLongitudEnMetros());
        Consola.imprimirMensaje("Dificultad :" + carreraDTO.getDificultad());    
        Consola.imprimirMensaje("");
        Consola.imprimirMensajeConSatoDeLinea("Corredores registrados");
        //****
        List<Object[]> filas = new ArrayList();
        for (Corredor corredor : carrera.getListaDeCorredores()) {
            corredorDTO = mapeadorDTO.crearCorredorDTO(corredor);
            filas.add(corredorDTO.getDatosCompletos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeCorredor(), filas);
        tabla.imprimirTabla();
        //****
    }

    /*
    Columnas de tablas
     */
    private Columna[] obtenerColumnasDeCarrera() {
        Columna[] columnas = new Columna[10];
        columnas[0] = new Columna("Carrera Id", 12);
        columnas[1] = new Columna("Fecha", 15);
        columnas[2] = new Columna("Vueltas", 9);
        columnas[3] = new Columna("Premio", 15);
        columnas[4] = new Columna("Estado", 12);
        columnas[5] = new Columna("Corredores", 12);
        columnas[6] = new Columna("Circuito Id", 13);
        columnas[7] = new Columna("Circuito", 20);
        columnas[8] = new Columna("Longitud", 10);
        columnas[9] = new Columna("Dificultad", 10);
        return columnas;
    }

    private Columna[] obtenerColumnasDeCircuito() {
        Columna[] columnas = new Columna[4];
        columnas[0] = new Columna("CircuitoId", 13);
        columnas[1] = new Columna("Nombre", 20);
        columnas[2] = new Columna("Longitud", 10);
        columnas[3] = new Columna("Dificultad", 10);
        return columnas;
    }

    private Columna[] obtenerColumnasDePiloto() {
        Columna[] columnas = new Columna[3];
        columnas[0] = new Columna("PilotoId", 11);
        columnas[1] = new Columna("Nombre", 30);
        columnas[2] = new Columna("Experiencia", 11);
        return columnas;
    }
    
    private Columna[] obtenerColumnasDeAuto(){
        Columna[] columnas = new Columna[3];
        columnas[0] = new Columna("AutoId", 10);
        columnas[1] = new Columna("Motor", 15);
        columnas[2] = new Columna("VelMáxima", 10);
        return columnas;
    }
    
    private Columna[] obtenerColumnasDeCorredor() {
        Columna[] columnas = new Columna[7];
        columnas[0] = new Columna("CorredorId", 15);
        columnas[1] = new Columna("PilotoId", 12);
        columnas[2] = new Columna("Nombre", 25);
        columnas[3] = new Columna("Experiencia", 13);
        columnas[4] = new Columna("AutoId", 10);
        columnas[5] = new Columna("Motor", 15);
        columnas[6] = new Columna("VelMáxima", 10);
        return columnas;
    }

}