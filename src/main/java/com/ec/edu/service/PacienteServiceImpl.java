package com.ec.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.edu.modelo.Paciente;
import com.ec.edu.modelo.ReporteTO;
import com.ec.edu.repository.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo pacienteRepo;

	@Override
	public void guardarPaciente(Paciente paciente) {
		this.pacienteRepo.insertarPaciente(paciente);
		
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.actualizarPaciente(paciente);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPaciente(id);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepo.elimianrPaciente(id);
	}

	@Override
	public Paciente busPacienteCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPacienteCodigo(codigo);
	}

	@Override
	public List<ReporteTO> reporteSencillo(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.reporteSencillo(fechaNacimiento, genero);
	}
	
	
}
