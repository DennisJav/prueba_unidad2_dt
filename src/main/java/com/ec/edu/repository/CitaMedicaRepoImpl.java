package com.ec.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ec.edu.modelo.CitaMedica;
import com.ec.edu.modelo.Doctor;

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

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		
		return this.EntityManager.find(CitaMedica.class, id);
	}

	@Override
	public void borrarCita(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica cita = this.buscarCitaMedica(id);
		this.EntityManager.remove(cita);
	}

	@Override
	public CitaMedica buscarCitaMedicaNumero(String numero) {
		
		TypedQuery<CitaMedica> typedQuery = this.EntityManager.createQuery("SELECT c FROM CitaMedica c where c.numero =: valor", CitaMedica.class);
		typedQuery.setParameter("valor", numero);

		return typedQuery.getSingleResult();	
	}

	
}
