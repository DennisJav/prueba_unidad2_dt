package com.ec.edu.service;

import com.ec.edu.modelo.Doctor;

public interface IDoctorService {

	void guardarDoctor(Doctor doctor);
	void actualizarDoctor(Doctor doctor);
	Doctor buscarDoctor(Integer id);
	Doctor buscarDoctorCedula(String cedula);
	void borrarDoctor(Integer id);
}
