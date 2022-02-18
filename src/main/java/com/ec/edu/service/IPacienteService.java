package com.ec.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ec.edu.modelo.Paciente;
import com.ec.edu.modelo.ReporteTO;

public interface IPacienteService {

	void guardarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	Paciente busPacienteCodigo(String codigo);
	void borrarPaciente(Integer id);
	List<ReporteTO> reporteSencillo (LocalDateTime fechaNacimiento, String genero);
	
	
}
