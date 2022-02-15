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
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;

	@Override
	public void agendarCitaMedica(String Número, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String apellidoDoctor, String codigoSeguroPaciente) {
	
		Doctor doctor = this.doctorService.buscarDoctorApellido(apellidoDoctor);
		Paciente paciente = this.pacienteService.busPacienteCodigo(codigoSeguroPaciente);

		CitaMedica citaMedica = new CitaMedica();
		
		citaMedica.setNumero(Número);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setLugar(lugarCita);
		citaMedica.setDoctor(doctor);
		citaMedica.setPaciente(paciente);
		
		LocalDateTime fechaActual = LocalDateTime.now();

		if (fechaCita.isAfter(fechaActual)) {
			
			BigDecimal temp = valorCita.multiply(new BigDecimal(0.12));
			citaMedica.setValorCita(valorCita.add(temp));
			
			this.citaMedicaRepo.agendarCita(citaMedica);
			LOG.info("Se ha agendado una cita");
		} else {
			LOG.warn("No se pudo agendar la cita");
		}

		
		
		
	}

	@Override
	public void actualizarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		
	}


	
	
}
