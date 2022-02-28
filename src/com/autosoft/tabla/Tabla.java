package com.autosoft.tabla;

import com.autosoft.util.Consola;
import java.util.List;

/**
 *
 * @author Lain
 */
public class Tabla {

    private Columna[] columnas;
    private List<Object[]> filas;

    public Tabla(Columna[] columnas, List<Object[]> filas) {
        this.columnas = columnas;
        this.filas = filas;
    }

    public void imprimirTabla() {
        String textoDeColumnas = "", textoFila = "";
        int diferencia;

        for (Columna columna : columnas) {
            textoDeColumnas += obtenerTexto(columna.getNombre(), columna.getAncho());
        }
        textoDeColumnas = "| " + textoDeColumnas + " |";
        Consola.imprimirLinea(textoDeColumnas.length());
        Consola.imprimirSubTitulo(textoDeColumnas);

        for (Object[] fila : filas) {
            for (int i = 0; i < fila.length; i++) {
                textoFila += obtenerTexto(fila[i].toString(), columnas[i].getAncho());
            }
            textoFila = "| " + textoFila + " |";
            Consola.imprimirMensaje(textoFila);
            textoFila = "";
        }
        Consola.imprimirLinea(textoDeColumnas.length());
    }

    private String obtenerTexto(String texto, int ancho) {
        String textoEnBlanco = " ";
        int totalDeEspacio = ancho - texto.length();
        return texto + textoEnBlanco.repeat(totalDeEspacio);
    }
}
