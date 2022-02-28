package com.autosoft.util;

import java.util.Timer;

public class AnimacionAnuncio implements IAnimacion{
String anuncio;

    public AnimacionAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }
//
//    public void imprimirAnuncio(String anuncio) {
//        long tiempoDeEspera = anuncio.length() * 200;
//        Timer temporizador = new Timer();
//        ImprimirAnuncio tareaMostrarAnuncio = new ImprimirAnuncio(anuncio);
//        temporizador.schedule(tareaMostrarAnuncio, 0, 250);
//        try {
//            Thread.sleep(tiempoDeEspera);
//        } catch (InterruptedException e) {
//        }
//        temporizador.cancel();
//    }

//    public void imprimirCarreraDeAuto() {
//        Timer temporizador = new Timer();
//        ImprimirCarreraDeAuto tareaImprimirAuto = new ImprimirCarreraDeAuto();
//        temporizador.schedule(tareaImprimirAuto, 0, 250);
//        try {
//            Thread.sleep(17000);
//        } catch (InterruptedException e) {
//        }
//        temporizador.cancel();
//    }

    @Override
    public void imprimir() {
        long tiempoDeEspera = anuncio.length() * 200L;
        Timer temporizador = new Timer();
        ImprimirAnuncio imprimirAnuncio = new ImprimirAnuncio(anuncio);
        temporizador.schedule(imprimirAnuncio, 0, 250);
        try {
            Thread.sleep(tiempoDeEspera);
        } catch (InterruptedException e) {
        }
        temporizador.cancel();
    }
}
