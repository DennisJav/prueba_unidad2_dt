package com.ec.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.edu.modelo.Doctor;
import com.ec.edu.repository.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void guardarDoctor(Doctor doctor) {
		this.doctorRepo.insertarDoctor(doctor);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {	
		this.doctorRepo.actualizarDoctor(doctor);
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		return this.doctorRepo.buscarDoctor(id);
	}

	@Override
	public void borrarDoctor(Integer id) {
		this.doctorRepo.borrarDoctor(id);
	}

	@Override
	public Doctor buscarDoctorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarDoctorCedula(cedula);
	}
	
	
	
}
