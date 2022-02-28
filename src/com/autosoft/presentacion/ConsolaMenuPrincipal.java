package com.autosoft.presentacion;

import com.autosoft.util.Consola;
import com.autosoft.entidad.Usuario;

public class ConsolaMenuPrincipal extends ConsolaDeEntrada {

    public ConsolaMenuPrincipal() {
        super("MENÚ PRINCIPAL");
    }

    @Override
    public void mostrar() {
        String opcion = "", opciones = "1234567";
        do {
            String[] opcionesDeMenu = new String[7];
            opcionesDeMenu[0] = "(1) Configurar Carreras";
            opcionesDeMenu[1] = "(2) Ejecutar Carreras";
            opcionesDeMenu[2] = "(3) Generar Estadisticas";
            opcionesDeMenu[3] = "(4) Consultar Circuitos";
            opcionesDeMenu[4] = "(5) Consultar Pilotos";
            opcionesDeMenu[5] = "(6) Consultar Autos";
            opcionesDeMenu[6] = "(7) Salir";
            mostrarEncabezado();
            Consola.imprimirMensajes(opcionesDeMenu);
            do {
                Consola.imprimirMensajeConSatoDeLinea(">> Ingrese el número:");
                opcion = entradaDeConsola.next();
            } while (opcion.length() > 1 || !opciones.contains(opcion));
            switch (opcion) {
                case "1":
                    mostrarConsolaDeEntrada(new ConsolaConfigurarCarrera());
                    break;
                case "2":
                    mostrarConsolaDeEntrada(new ConsolaEjecutarCarrera());
                    break;
                case "3":
                    mostrarConsolaDeEntrada(new ConsolaGenerarEstadistica());
                    break;
                case "4":
                    mostrarConsolaDeReporte(new ConsolaReporteDeCircuitos());
                    break;
                case "5":
                    mostrarConsolaDeReporte(new ConsolaReporteDePilotos());
                    break;
                case "6":
                    mostrarConsolaDeReporte(new ConsolaReporteDeAutos());
                case "7":
                    salir();
            }
        } while (!opcion.equals("7"));
    }

    private void mostrarConsolaDeEntrada(ConsolaDeEntrada consolaDeEntrada) {
        consolaDeEntrada.mostrar();
    }

    private void mostrarConsolaDeReporte(ConsolaDeReporte consolaDeReporte) {
        consolaDeReporte.mostrar();
    }

    private void salir() {
        Usuario usuario = Usuario.obtenerInstancia();
        Consola.imprimirTituloPrincipal();
        Consola.imprimirMensaje("Gracias por jugar " + usuario.getNombre() + ", acumulaste S/ " + usuario.getPremioAcumulado() + " de premio");
    }

}//end ConsolaGestionarCarrera
