package com.autosoft.util;

import java.util.TimerTask;

public class ImprimirCarreraDeAuto extends TimerTask {

    private int tabulacion;

    public ImprimirCarreraDeAuto() {
        tabulacion = 0;
    }

    @Override
    public void run() {
        imprimirAuto();
        tabulacion++;
    }

    private void imprimirAuto() {
        String espacio = " ";
        String espacioDeTabulacion = espacio.repeat(tabulacion);
        int longitudDeLinea = Consola.TITULO_PRINCIPAL.length();
        if (espacioDeTabulacion.length() <= longitudDeLinea - 9) {
            Consola.imprimirTituloPrincipal();
            Consola.imprimirMensaje(espacioDeTabulacion + "  ____    ");
            Consola.imprimirMensaje(espacioDeTabulacion + " / [] \\_ ");
            Consola.imprimirMensaje(espacioDeTabulacion + " =O===O=° ");
            Consola.imprimirLinea(longitudDeLinea);
        }
    }
}
