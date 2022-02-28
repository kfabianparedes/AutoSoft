package com.autosoft.presentacion;

import com.autosoft.dto.CarreraDTO;
import com.autosoft.entidad.Carrera;
import com.autosoft.mapeador.Mapeador;
import com.autosoft.repositorio.CatalogoDeCarreras;
import com.autosoft.tabla.Columna;
import com.autosoft.tabla.Tabla;
import com.autosoft.util.Consola;
import java.util.ArrayList;
import java.util.List;

public class ConsolaEjecutarCarrera extends ConsolaDeEntrada{

    public ConsolaEjecutarCarrera() {
        super("EJECUTAR CARRERAS");
    }

    @Override
    public void mostrar() {
        String opcion = "";
        do{
            mostrarEncabezado();
            mostrarCarrerasSinIniciar();
            do{
                Consola.imprimirMensajeConSatoDeLinea(">> (J) Jugar | (S) Salir");
            }while(!opcion.equals("J") && !opcion.equals("S"));
            if(opcion.endsWith("J")){
                ejecutarCarrera();
            }
        }while (!opcion.equals("S"));
    }

    private void mostrarCarrerasSinIniciar() {
        Consola.imprimirMensaje("Carreras para jugar");
        CatalogoDeCarreras catalogoDeCarreras = CatalogoDeCarreras.obtenerInstancia();
        List<Carrera> listaDeCarrerasSinIniciar = catalogoDeCarreras.obtenerCarrerasSinIniciar();
        List<Object[]> filas = new ArrayList();
        Mapeador mapeadorDTO = new Mapeador();
        for(Carrera carrera : listaDeCarrerasSinIniciar){
            CarreraDTO carreraDTO = mapeadorDTO.crearCarreraDTO(carrera);
            filas.add(carreraDTO.getDatosCompletos());
        }
        Tabla tabla = new Tabla(obtenerColumnasDeCarrera(),filas);
            
    }

    private void ejecutarCarrera() {
    }
    
    private Columna[] obtenerColumnasDeCarrera(){
        Columna[] columnas = new Columna[10];
        columnas[0] = new Columna("CarreraId",12);
        columnas[1] = new Columna("Fecha",15);
        columnas[2] = new Columna("Vueltas",9);
        columnas[3] = new Columna("Premio",15);
        columnas[4] = new Columna("Estado",12);
        columnas[5] = new Columna("Corredores",12);
        columnas[6] = new Columna("CircuitoId",13);
        columnas[7] = new Columna("Circuito",20);
        columnas[8] = new Columna("Longitud",10);
        columnas[9] = new Columna("Dificultad",10);

        return columnas;
    }
}
