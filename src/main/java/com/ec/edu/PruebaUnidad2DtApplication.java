package com.ec.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ec.edu.modelo.CitaMedica;
import com.ec.edu.modelo.Doctor;
import com.ec.edu.modelo.Paciente;
import com.ec.edu.modelo.ReporteTO;
import com.ec.edu.repository.IDoctorRepo;
import com.ec.edu.service.CitaMedicaServiceImpl;
import com.ec.edu.service.ICitaMedicaService;
import com.ec.edu.service.IDoctorService;
import com.ec.edu.service.IGestorCitaService;
import com.ec.edu.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2DtApplication implements CommandLineRunner{


	static final Logger LOG = Logger.getLogger(PruebaUnidad2DtApplication.class);
	
	
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private ICitaMedicaService citaMedicaService;
	@Autowired
	private IGestorCitaService gestorService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2DtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//CREAMOS 2 DOCTORES
//		
//		Doctor doc1 = new Doctor();
//				
//		doc1.setApellido("tapia");
//		doc1.setCedula("12131");
//		
//		LocalDateTime miFecha = LocalDateTime.of(1989, Month.AUGUST,8,2,2);
//		
//		doc1.setFechaNacimiento(miFecha);
//		doc1.setCodigoSenecyt("dasdas");
//		doc1.setGenero("M");
//		doc1.setNombre("Dennis");
//		doc1.setNumCosultorio(12);
//		
//		this.doctorService.guardarDoctor(doc1);
//		
//		Doctor doc2 = new Doctor();
//		
//		doc2.setApellido("tapia");
//		doc2.setCedula("12131");
//		
//		LocalDateTime miFecha2 = LocalDateTime.of(1989, Month.AUGUST,8,2,2);
//		
//		doc2.setFechaNacimiento(miFecha2);
//		doc2.setCodigoSenecyt("dasdas");
//		doc2.setGenero("M");
//		doc2.setNombre("Javier");
//		doc2.setNumCosultorio(12);
//		doc2.setApellido("Ortiz");
//		
//		this.doctorService.guardarDoctor(doc2);
//		
//		
//		//INSERTAMOS 2 PACIENTES
//		
//		Paciente pac1 = new Paciente();
//		
//		pac1.setNombre("Jairo");
//		pac1.setApellido("Romero");
//		pac1.setCedula("123121321");
//		pac1.setCodigoSeguro("assd1212");
//		pac1.setEstatura(new BigDecimal(1.89));
//		LocalDateTime miFecha3 = LocalDateTime.of(1996, Month.JANUARY,16,01,2);
//		pac1.setFechaNacimiento(miFecha3);
//		pac1.setPeso(new BigDecimal(68));
//		
//		this.pacienteService.guardarPaciente(pac1);
//		
//		Paciente pac2 = new Paciente();
//		
//		pac2.setNombre("Loro");
//		pac2.setApellido("Homero");
//		pac2.setCedula("123121321");
//		pac2.setCodigoSeguro("assd1212");
//		pac2.setEstatura(new BigDecimal(1.69));
//		LocalDateTime miFecha4 = LocalDateTime.of(1986, Month.JANUARY,16,01,2);
//		pac2.setFechaNacimiento(miFecha4);
//		pac2.setPeso(new BigDecimal(68));
//	
//		this.pacienteService.guardarPaciente(pac2);
//		
		//Actualizaciones
		
////		//Paciente
//		Paciente pacienteActualizar = new Paciente();
//		pacienteActualizar.setId(1);
//		pacienteActualizar.setNombre("Maria");
//		pacienteActualizar.setApellido("Carton");
//		pacienteActualizar.setCedula("12223666");
//		pacienteActualizar.setCodigoSeguro("AE22");
//		pacienteActualizar.setEstatura(new BigDecimal(1.59));
//		LocalDateTime miFecha5 = LocalDateTime.of(1999, Month.JANUARY,16,01,2);
//		pacienteActualizar.setFechaNacimiento(miFecha5);
//		pacienteActualizar.setPeso(new BigDecimal(59));
//		this.pacienteService.actualizarPaciente(pacienteActualizar);
////		
//		//Doctor
//		
//		Doctor docActualizar = new Doctor();
//		docActualizar.setId(1);
//		docActualizar.setCedula("12233211");
//		docActualizar.setApellido("Arias");
//		this.doctorService.actualizarDoctor(docActualizar);
//		
		
//
//		//cita medica agendar por numero cita, fecha cita, valor cita, lugar cita, apellido doctor, codigo seguro paciente
//		LocalDateTime fechaAgenda = LocalDateTime.of(2022, Month.APRIL, 18, 13, 00);
//		this.gestorService.agendarCitaMedica("13", fechaAgenda, new BigDecimal(12), "Calderon", "tapia", "AE22");
		
		
		LocalDateTime fechaA = LocalDateTime.of(2022, Month.APRIL, 18, 13, 00);
		this.gestorService.resultadoCita("13","Gripe" , "Paracetamol", fechaA);
		
		
		LocalDateTime fechaB = LocalDateTime.of(1999, Month.JANUARY,16,01,2);
		List<ReporteTO> resu1 = this.pacienteService.reporteSencillo(fechaB, "M");
		LOG.debug("Pacientes con fecha de nacimeinto mayor a: "+fechaB+" de genero: "+"Masculino son : "+resu1.size());
		for(ReporteTO r:resu1) {
	    	LOG.info(r.toString());
	    } 
		
	}

}
