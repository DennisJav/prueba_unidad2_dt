package com.ec.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ec.edu.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{

	public static final Logger LOG = LoggerFactory.getLogger(DoctorRepoImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void insertarDoctor(Doctor doctor) {
		this.entityManager.persist(doctor);
	}


	@Override
	public void actualizarDoctor(Doctor doctor) {
		this.entityManager.merge(doctor);
	}


	@Override
	public Doctor buscarDoctor(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}


	@Override
	public void borrarDoctor(Integer id) {
		Doctor doctorBorrar = this.buscarDoctor(id);
		this.entityManager.remove(doctorBorrar);
	}


	@Override
	public Doctor buscarDoctorApellido(String apellido) {
		
		TypedQuery<Doctor> typedQuery = this.entityManager.createQuery("SELECT d FROM Doctor d where d.apellido =: valor", Doctor.class);
		typedQuery.setParameter("valor", apellido);

		return typedQuery.getSingleResult();	
		
	
	}
	
	
}
