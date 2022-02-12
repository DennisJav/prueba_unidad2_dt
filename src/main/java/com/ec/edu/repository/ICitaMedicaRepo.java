package com.ec.edu.repository;

import com.ec.edu.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	void agendarCita(CitaMedica citaMedica);
	void actualizarCita(CitaMedica citaMedica);
}
