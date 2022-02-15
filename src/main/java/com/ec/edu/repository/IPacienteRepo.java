package com.ec.edu.repository;

import com.ec.edu.modelo.Paciente;

public interface IPacienteRepo {

	void insertarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	Paciente buscarPacienteCodigo(String codigo);
	void elimianrPaciente(Integer id);
	
}
