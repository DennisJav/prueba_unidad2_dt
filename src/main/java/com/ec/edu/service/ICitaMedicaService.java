package com.ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ec.edu.modelo.CitaMedica;

public interface ICitaMedicaService {
	
	void agendarCitaMedica(String Número, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String apellidoDoctor, String codigoSeguroPaciente);
	void actualizarCitaMedica(CitaMedica citaMedica);
	void reportarCitaMedica(CitaMedica citaMedica);
	void eliminarCitaMedica(Integer id);
}
