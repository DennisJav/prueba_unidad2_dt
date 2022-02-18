package com.ec.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.edu.modelo.CitaMedica;
import com.ec.edu.modelo.Doctor;
import com.ec.edu.modelo.Paciente;
import com.ec.edu.repository.ICitaMedicaRepo;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService {
	static final Logger LOG = Logger.getLogger(GestorCitaServiceImpl.class);

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired ICitaMedicaService citaMedicaService;

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
		citaMedica.setValorCita(valorCita);
		
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
	public void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime proximaFecha) {
		// TODO Auto-generated method stub
	
	       CitaMedica c1 = this.citaMedicaService.buscarPorNumero(numero);
	        c1.setDiagnostico(diagnostico);
	        c1.setReceta(receta);
	        c1.setFechaProximaCita(proximaFecha);
	        this.citaMedicaService.actualizarCitaMedica(c1);
	}

}
