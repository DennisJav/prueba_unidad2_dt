package com.ec.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.edu.modelo.CitaMedica;
import com.ec.edu.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;

	@Override
	public void actualizarCita(CitaMedica citaMedica) {
	
		this.citaMedicaRepo.actualizarCita(citaMedica);
		
	}

	@Override
	public void guardarCita(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.agendarCita(citaMedica);
	}
	
	
}
