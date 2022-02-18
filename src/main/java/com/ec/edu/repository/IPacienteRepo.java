package com.ec.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.ec.edu.modelo.Paciente;
import com.ec.edu.modelo.ReporteTO;

public interface IPacienteRepo {

	void insertarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	Paciente buscarPacienteCodigo(String codigo);
	void elimianrPaciente(Integer id);
	List<ReporteTO> reporteSencillo (LocalDateTime fechaNacimiento, String genero);
	
}
