package com.ec.edu.repository;

import com.ec.edu.modelo.Paciente;

public interface IPacienteRepo {

	void insertarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	void elimianrPaciente(Integer id);
	
}
