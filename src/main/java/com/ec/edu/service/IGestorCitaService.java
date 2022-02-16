package com.ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaService {

	void agendarCitaMedica(String Número, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String apellidoDoctor, String codigoSeguroPaciente);

	void resultadoCita(String numero, String diagnostico,String receta, LocalDateTime proximaFecha);
	
}
