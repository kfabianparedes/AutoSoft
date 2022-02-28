package com.autosoft.presentacion;

import com.autosoft.util.Consola;
import java.util.Scanner;

/**
 *
 * @author Windows10
 */
public abstract class ConsolaDeEntrada {

    private final String titulo;
    public Scanner entradaDeConsola;

    public ConsolaDeEntrada(String titulo) {
        entradaDeConsola = new Scanner(System.in);
        this.titulo = titulo;
    }

    public void mostrarEncabezado() {
        Consola.imprimirTituloPrincipal();
        Consola.imprimirTitulo(titulo);
    }
    
    public abstract void mostrar();

}
