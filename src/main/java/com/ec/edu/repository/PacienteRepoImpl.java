package com.ec.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ec.edu.modelo.Paciente;



@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{
	public static final Logger LOG = LoggerFactory.getLogger(PacienteRepoImpl.class);


	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void insertarPaciente(Paciente paciente) {
		this.entityManager.persist(paciente);
		
	}


	@Override
	public void actualizarPaciente(Paciente paciente) {
		this.entityManager.merge(paciente);
		
	}


	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}


	@Override
	public void elimianrPaciente(Integer id) {
		Paciente pacienteBorrar = this.buscarPaciente(id);
		this.entityManager.remove(pacienteBorrar);
	}
	
	
	
	
	
	
}
