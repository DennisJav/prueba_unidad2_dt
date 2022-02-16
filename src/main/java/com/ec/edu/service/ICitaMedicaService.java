package com.ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ec.edu.modelo.CitaMedica;

public interface ICitaMedicaService {
	
	void insertar(CitaMedica citaMedica);
	void actualizarCitaMedica(CitaMedica citaMedica);
	CitaMedica buscarPorNumero(String numero);
	
}
