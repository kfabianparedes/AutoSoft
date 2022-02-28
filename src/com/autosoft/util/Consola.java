package com.autosoft.util;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Lain
 */
public class Consola {

    public static String TITULO_PRINCIPAL = "  /\\_/\\_/\\ PROGRAMA DE SIMULACIÓN DE CARRERAS DE AUTOS /\\_/\\_/\\  ";

    public static void limpiar() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            imprimirMensaje("Error al intentar limpiar consola");
        } catch (InterruptedException e) {
            imprimirMensaje("Error al intentar limpiar consola");
        }
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.println();
        System.out.print("     " + mensaje + " ");
    }

    public static void imprimirMensajeConTabulacion(String mensaje, int tabulacion) {
        String textobacio = " ";
        imprimirMensaje(textobacio.repeat(tabulacion) + mensaje);
    }

    public static void imprimirMensajes(String[] mensajes) {
        for (int i = 0; i < mensajes.length; i++) {
            imprimirMensaje(mensajes[i]);
        }
    }

    public static void imprimirMensajes(List<String> mensajes) {
        for (String mensaje : mensajes) {
            imprimirMensaje(mensaje);
        }
    }

    public static void imprimirMensajeConSatoDeLinea(String mensaje) {
        System.out.println();
        imprimirMensaje(mensaje);
    }

    public static void imprimirMensajesConSatoDeLinea(String[] mensajes) {
        for (int i = 0; i < mensajes.length; i++) {
            imprimirMensajeConSatoDeLinea(mensajes[i]);
        }
    }

    public static void imprimirMensajesConSatoDeLinea(List<String> mensajes) {
        for (String mensaje : mensajes) {
            imprimirMensajeConSatoDeLinea(mensaje);
        }
    }

    public static void imprimirTituloPrincipal() {
        limpiar();
        imprimirDobleLinea(TITULO_PRINCIPAL.length());
        imprimirMensaje(TITULO_PRINCIPAL);
        imprimirDobleLinea(TITULO_PRINCIPAL.length());
        System.out.println();
    }

    public static void imprimirTitulo(String titulo) {
        int tabulacion = (TITULO_PRINCIPAL.length() / 2) - (titulo.length() / 2);
        imprimirMensajeConTabulacion(titulo, tabulacion);
        imprimirDobleLineaConTabulacion(titulo.length(), tabulacion);
        System.out.println();
    }

    public static void imprimirSubTitulo(String subtitulo) {
        imprimirMensaje(subtitulo);
        imprimirLinea(subtitulo.length());
    }

    public static void imprimirTituloInverso(String titulo) {
        imprimirLinea(titulo.length());
        imprimirMensaje(titulo);
        System.out.println();
    }

    public static void imprimirLinea(int longitud) {
        String linea = "-";
        imprimirMensaje(linea.repeat(longitud));
    }

    public static void imprimirDobleLinea(int longitud) {
        String linea = "=";
        imprimirMensaje(linea.repeat(longitud));
    }

    public static void imprimirDobleLineaConTabulacion(int longitud, int tabulacion) {
        String doblelinea = "=";
        imprimirMensajeConTabulacion(doblelinea.repeat(longitud), tabulacion);
    }

    public static boolean tieneSoloNumeros(String texto) {
        String caracteresValidos = "0123456789";
        return esTextoValido(texto, caracteresValidos);
    }

    public static boolean tieneSoloLetras(String texto) {
        String caracteresValidos = "abcdefghijklmnñopqrstuvwxyABCDEFGHIJKLMNÑOPQRSTUVWXY";
        return esTextoValido(texto, caracteresValidos);
    }

    public static boolean esTextoValido(String texto, String caracteresValidos) {
        boolean esTextoValido = true;
        for (char caracter : texto.toCharArray()) {
            if (!caracteresValidos.contains(String.valueOf(caracter))) {
                esTextoValido = false;
                break;
            }
        }
        return esTextoValido;
    }

    public static boolean esEntero(String texto) {
        boolean es_entero;
        try {
            Integer.parseInt(texto);
            es_entero = true;
        } catch (NumberFormatException e) {
            es_entero = false;
        }
        return es_entero;
    }

    public static boolean esDecimal(String texto) {
        boolean es_decimal;
        try {
            Double.parseDouble(texto);
            es_decimal = true;
        } catch (NumberFormatException e) {
            es_decimal = false;
        }
        return es_decimal;
    }
}
