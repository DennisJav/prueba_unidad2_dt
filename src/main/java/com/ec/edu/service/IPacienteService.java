package com.ec.edu.service;

import com.ec.edu.modelo.Paciente;

public interface IPacienteService {

	void guardarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	Paciente busPacienteCodigo(String codigo);
	void borrarPaciente(Integer id);
	
}
