package com.ec.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ec.edu.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo{
	
	public static final Logger LOG = LoggerFactory.getLogger(CitaMedicaRepoImpl.class);

	
	@PersistenceContext
	private EntityManager EntityManager;

	@Override
	public void agendarCita(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.EntityManager.persist(citaMedica);
	}

	@Override
	public void actualizarCita(CitaMedica citaMedica) {
		this.EntityManager.merge(citaMedica);
	}

	
}
