package com.autosoft.mapeador;
import com.autosoft.dto.CarreraDTO;
import com.autosoft.dto.CarreraEstadisticaDTO;
import com.autosoft.dto.CorredorDTO;
import com.autosoft.dto.CorredorEstadisticaDTO;
import com.autosoft.entidad.Auto;
import com.autosoft.entidad.Carrera;
import com.autosoft.entidad.Circuito;
import com.autosoft.entidad.Corredor;
import com.autosoft.entidad.Piloto;
import com.autosoft.entidad.Vuelta;
import java.text.DecimalFormat;

public class Mapeador {

    public String formatearNumero(double numero) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("#0.00");
        return df.format(numero);
    }
    
    public CarreraDTO crearCarreraDTO(Carrera carrera) {
        Circuito circuito = carrera.getCircuito();
        CarreraDTO carreraDTO = new CarreraDTO();

        carreraDTO.setCarreraId(carrera.getCarrera_id());
        carreraDTO.setFecha(carrera.getFecha());
        carreraDTO.setVueltas(carrera.getVueltas());
        carreraDTO.setPremio("S/ " + carrera.getPremio());
        carreraDTO.setTerminada(carrera.isTerminada() ? "Terminada" : "No inicida");
        carreraDTO.setTotalCorredores(carrera.obtenerTotalDeCorredores());
        carreraDTO.setCircuitoId(circuito.getCircuito_id());
        carreraDTO.setCircuitoNombre(circuito.getNombre());
        carreraDTO.setLongitudEnMetros(circuito.getLongitudEnMetros() + " mt");
        carreraDTO.setDificultad(circuito.getDificultad());        
        return carreraDTO;
    }

    public CarreraEstadisticaDTO crearCarreraEstadisticaDTO(Carrera carrera) {
        Circuito circuito = carrera.getCircuito();
        CarreraEstadisticaDTO carreraEstadisticaDTO = new CarreraEstadisticaDTO();

        carreraEstadisticaDTO.setCarreraId(carrera.getCarrera_id());
        carreraEstadisticaDTO.setVueltas(carrera.getVueltas());
        carreraEstadisticaDTO.setTotalDeCorredores(carrera.obtenerTotalDeCorredores());
        carreraEstadisticaDTO.setLongitudEnMetros(circuito.getLongitudEnMetros() + " mt");
        Corredor corredor = carrera.obtenerCorredorGanador();
        carreraEstadisticaDTO.setPilotoGanador(corredor.getPiloto().getNombre());
        carreraEstadisticaDTO.setTiempoPiloto(formatearNumero(corredor.calcularTiempoDeCarrera()) + " min");
        carreraEstadisticaDTO.setTiempoPromedio(formatearNumero(carrera.calcularTiempoPromedio()) + " min");
        carreraEstadisticaDTO.setVarianzaDelTiempo(formatearNumero(carrera.calcularVarianzaDelTiempo()));
        carreraEstadisticaDTO.setDesviacionEstandarDelTiempo(formatearNumero(carrera.calcularDesviacionEstandarDelTiempo()));

        return carreraEstadisticaDTO;
    }

    public CorredorDTO crearCorredorDTO(Corredor corredor) {
        Piloto piloto = corredor.getPiloto();
        Auto auto = corredor.getAuto();
        CorredorDTO corredorDTO = new CorredorDTO();

        corredorDTO.setCorredorId(corredor.getCorredor_id());
        corredorDTO.setPilotoId(piloto.getPiloto_id());
        corredorDTO.setPilotoNombre(piloto.getNombre());
        corredorDTO.setPilotoTiempodeexperiencia(piloto.getTiempodeexperiencia() + " años");
        corredorDTO.setAutoId(auto.getAuto_id());
        corredorDTO.setAutoMotor(auto.getModelo());
        corredorDTO.setAutoVelocidadmaxima(auto.getMaximavelocidad() + " Km/h");

        return corredorDTO;
    }

    public CorredorEstadisticaDTO crearCorredorEstadisticaDTO(Corredor corredor) {
        Piloto piloto = corredor.getPiloto();
        Auto auto = corredor.getAuto();
        Vuelta vueltaRapida = corredor.obtenerVueltaMasRapida();
        Vuelta vueltaLenta = corredor.obtenerVueltaMasLenta();
        CorredorEstadisticaDTO corredorEstadisticaDTO = new CorredorEstadisticaDTO();

        corredorEstadisticaDTO.setPuesto(corredor.getPuesto());
        corredorEstadisticaDTO.setCorredorId(corredor.getCorredor_id());
        corredorEstadisticaDTO.setPilotoNombre(piloto.getNombre());
        corredorEstadisticaDTO.setMotor(auto.getModelo());

        corredorEstadisticaDTO.setTiempoDeCarrera(formatearNumero(corredor.calcularTiempoDeCarrera()) + " min");
        corredorEstadisticaDTO.setTiempoPromedioDeVuelta(formatearNumero(corredor.calcularTiempoPromedioDeVuelta()) + " min");
        corredorEstadisticaDTO.setVarianzaDelTiempo(formatearNumero(corredor.calcularVarianzaDelTiempo()));
        corredorEstadisticaDTO.setDesviacionEstandarDelTiempo(formatearNumero(corredor.calcularDesviacionEstandarDelTiempo()));

        corredorEstadisticaDTO.setVelocidadPromedioDeVuelta(formatearNumero(corredor.calcularVelocidadPromedioDeVuelta()) + " Km/h");

        corredorEstadisticaDTO.setVueltaMasRapida(vueltaRapida.getNumero());
        corredorEstadisticaDTO.setVelocidadVueltaRapida(formatearNumero(vueltaRapida.getVelocidad()) + " Km/h");
        corredorEstadisticaDTO.setTiempoVueltaRapida(formatearNumero(vueltaRapida.getTiempo()) + " min");

        corredorEstadisticaDTO.setVueltaMasLenta(vueltaLenta.getNumero());
        corredorEstadisticaDTO.setVelocidadVueltaLenta(formatearNumero(vueltaLenta.getVelocidad()) + " Km/h");
        corredorEstadisticaDTO.setTiempoVueltaLenta(formatearNumero(vueltaLenta.getTiempo()) + " min");

        return corredorEstadisticaDTO;
    }

}
