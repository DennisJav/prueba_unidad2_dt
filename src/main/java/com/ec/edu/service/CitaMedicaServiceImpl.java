package com.ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.edu.modelo.CitaMedica;
import com.ec.edu.modelo.Doctor;
import com.ec.edu.modelo.Paciente;
import com.ec.edu.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	static final Logger LOG = Logger.getLogger(CitaMedicaServiceImpl.class);

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	@Override
	public void actualizarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.agendarCita(citaMedica);
	}



	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepo.buscarCitaMedicaNumero(numero);
	}



	


	
	
}
