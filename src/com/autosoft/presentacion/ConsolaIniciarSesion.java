package com.autosoft.presentacion;

import com.autosoft.util.Consola;
import com.autosoft.entidad.Usuario;
import com.autosoft.util.AnimacionAnuncio;
import com.autosoft.util.IAnimacion;
import java.util.Scanner;

public class ConsolaIniciarSesion extends ConsolaDeEntrada {

    public static void main(String[] args) {
        IAnimacion animacionAnuncio = new AnimacionAnuncio(Consola.TITULO_PRINCIPAL);
        animacionAnuncio.imprimir();
        ConsolaIniciarSesion consolaIniciarSesion = new ConsolaIniciarSesion();
        consolaIniciarSesion.mostrar();
    }

    public ConsolaIniciarSesion() {
        super("INICIAR SESIÓN");
    }

    @Override
    public void mostrar() {
        mostrarEncabezado();
        Scanner entradaDeConsola = new Scanner(System.in);
        String entradaDeUsuario = "";
        do {
            Consola.imprimirMensajeConSatoDeLinea(">> ¡Bienvenido! Ingrese un nombre de Usuario (mínimo 3 letras) o 'S' para salir:");
            entradaDeUsuario = entradaDeConsola.next().toUpperCase();
        } while (!(entradaDeUsuario.length() == 1 && entradaDeUsuario.equals("S")) && (!Consola.tieneSoloLetras(entradaDeUsuario) || entradaDeUsuario.length() < 3));
        if (!entradaDeUsuario.equals("S")) {
            Usuario usuario = Usuario.obtenerInstancia();
            usuario.setNombre(entradaDeUsuario);
            ConsolaDeEntrada consolaMenuPrincipal = new ConsolaMenuPrincipal();
            consolaMenuPrincipal.mostrar();
        }
        Consola.imprimirMensajeConSatoDeLinea("¡Adios! fin del programa.");
        Consola.imprimirMensajeConSatoDeLinea("");
    }

}//end ProgramaMenuPrincipal
