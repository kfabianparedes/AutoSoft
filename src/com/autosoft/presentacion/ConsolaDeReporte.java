/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autosoft.presentacion;

import com.autosoft.util.Consola;
import java.util.Scanner;

/**
 *
 * @author Windows10
 */
public abstract class ConsolaDeReporte {

    private final String titulo;
    private final String piedepagina;

    public ConsolaDeReporte(String titulo, String piedepagina) {
        this.titulo = titulo;
        this.piedepagina = piedepagina;
        mostrarEncabezado();
    }

    public void mostrarEncabezado() {
//        Consola.limpiar();
        Consola.imprimirTituloPrincipal();
        Consola.imprimirTitulo(titulo);
    }

    public void mostrarPieDePagina() {
        Consola.imprimirMensaje(piedepagina);
        Scanner entradaDeConsola = new Scanner(System.in);
        String letra;
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> Ingrese 'S' para salir:");
            letra = entradaDeConsola.next().toUpperCase();
        } while (!letra.equals("S"));
    }

    public void mostrar() {
        mostrarDetalle();
        mostrarPieDePagina();
    }

    public abstract void mostrarDetalle();

}
