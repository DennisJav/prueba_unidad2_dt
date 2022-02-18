package com.ec.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ec.edu.modelo.Paciente;
import com.ec.edu.modelo.ReporteTO;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {
	public static final Logger LOG = LoggerFactory.getLogger(PacienteRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente paciente) {
		LOG.debug("GUARDANDO PACIENTE");
		this.entityManager.persist(paciente);

	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		LOG.debug("ACTULIZANDO PACIENTE");
		this.entityManager.merge(paciente);

	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		LOG.debug("BUSCANDO PACIENTE");
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void elimianrPaciente(Integer id) {
		Paciente pacienteBorrar = this.buscarPaciente(id);
		LOG.debug("BORRANDO PACIENTE");
		this.entityManager.remove(pacienteBorrar);
		
	}

	@Override
	public Paciente buscarPacienteCodigo(String codigoSeguro) {
		TypedQuery<Paciente> typedQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p where p.codigoSeguro =: valor", Paciente.class);
		typedQuery.setParameter("valor", codigoSeguro);
		LOG.debug("BUSCANDO PACIENTE CODIGO SEGURO");
		return typedQuery.getSingleResult();
	}

	@Override
	public List<ReporteTO> reporteSencillo(LocalDateTime fechaNacimiento, String genero) {
		LOG.debug("Imprimiendo reporte Sencillo");
		TypedQuery<ReporteTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.ec.edu.modelo.ReporteTO(r.cedula,r.nombre,r.fechaNacimiento,r.genero) FROM Paciente r WHERE r.fechaNacimiento>:fechaNac AND r.genero=:gen",
				ReporteTO.class);
		myQuery.setParameter("fechaNac", fechaNacimiento);
		myQuery.setParameter("gen", genero);
		LOG.debug("REPORTE SENCILLO PACIENTE");
		return myQuery.getResultList();
	}

}
