package com.hbt.semillero.servicios.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;

@Stateless
public class ConsultasBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {
		 return entityManager.createQuery("Select ma FROM Marca ma").getResultList();		
	}
	
	public List<Linea> consultarLineas(Long idMarca){
		Query consulta = entityManager.createQuery("Select ln FROM Linea ln join where ln.marca.idLinea =:ID_LINEA");
		consulta.setParameter("ID_LINEA", idMarca);
		return consulta.getResultList();
	}
}
