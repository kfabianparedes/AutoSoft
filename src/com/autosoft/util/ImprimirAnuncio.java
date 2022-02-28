package com.autosoft.util;

import java.util.TimerTask;

public class ImprimirAnuncio extends TimerTask {

    private int contador, tabulacion, mitadDeCaracteres, indiceMenor, indiceMayor;
    private String anuncio;

    public ImprimirAnuncio(String anuncio) {
        this.anuncio = anuncio;
        contador = 0;
        mitadDeCaracteres = anuncio.length() / 2;
        indiceMenor = mitadDeCaracteres;
        indiceMayor = mitadDeCaracteres;
        tabulacion = mitadDeCaracteres;
    }

    @Override
    public void run() {
        String texto = " ";
        if (contador < mitadDeCaracteres) {
            Consola.limpiar();
            Consola.imprimirDobleLinea(anuncio.length());
            Consola.imprimirMensaje(texto.repeat(tabulacion) + anuncio.substring(indiceMenor, indiceMayor));
            Consola.imprimirDobleLinea(anuncio.length());
            contador++;
            indiceMenor--;
            indiceMayor++;
            tabulacion = mitadDeCaracteres - contador;
        }
    }

}
