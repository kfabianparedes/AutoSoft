package com.autosoft.util;

import java.util.Timer;

public class AnimacionCarreraDeAuto implements IAnimacion {

    @Override
    public void imprimir() {
        Timer temporizador = new Timer();
        ImprimirCarreraDeAuto imprimirCarreraDeAuto = new ImprimirCarreraDeAuto();
        temporizador.schedule(imprimirCarreraDeAuto, 0, 250);
        try {
            Thread.sleep(17000);
        } catch (InterruptedException e) {
        }
        temporizador.cancel();
    }

}
