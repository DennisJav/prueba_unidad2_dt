package com.ec.edu.repository;

import com.ec.edu.modelo.Doctor;

public interface IDoctorRepo {

	void insertarDoctor(Doctor doctor);
	void actualizarDoctor(Doctor doctor);
	Doctor buscarDoctor(Integer id);
	Doctor buscarDoctorApellido(String apellido);
	void borrarDoctor(Integer id);
	
	
	
}
